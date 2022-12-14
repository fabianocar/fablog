package com.fabiano.fablog.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fabiano.fablog.domain.exception.BusinessException;
import com.fabiano.fablog.domain.exception.EntityNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
        HttpHeaders headers, HttpStatus status, WebRequest request) {
            
        List<Fild> filds = new ArrayList<>();
        for(Object error : ex.getBindingResult().getAllErrors()){
            String name = ((FieldError)error).getField();
            String message = messageSource.getMessage(((FieldError)error), LocaleContextHolder.getLocale());
            filds.add(new Fild(name, message));
        }
            
        Problem problem = new Problem();
        problem.setStatus(status.value());
        problem.setDateHour(OffsetDateTime.now());
        problem.setTitle("Um ou mais campos estão inválidos, corrija e tente novamente!");
        problem.setFilds(filds);

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFound(BusinessException be, WebRequest request){
       
        HttpStatus status = HttpStatus.NOT_FOUND;

        Problem problem = new Problem();
        problem.setStatus(status.value());
        problem.setDateHour(OffsetDateTime.now());
        problem.setTitle(be.getMessage());

        return handleExceptionInternal(be, problem, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusiness(BusinessException be, WebRequest request){
       
        HttpStatus status = HttpStatus.BAD_REQUEST;

        Problem problem = new Problem();
        problem.setStatus(status.value());
        problem.setDateHour(OffsetDateTime.now());
        problem.setTitle(be.getMessage());

        return handleExceptionInternal(be, problem, new HttpHeaders(), status, request);
    }
}
