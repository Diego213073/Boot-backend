package com.spring.app.bootbackend.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
@Log4j2
public class ExceptionHandlers {

    public void errorCode(ErrorCode errorCode, Exception e){
        log.info(errorCode.getCode());
        log.info(errorCode.getMessage());
        log.error(e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorCode exceptionHandlers(Exception e){
        ErrorCode errorCode = ErrorCode.builder().build();
        errorCode.setCode(UUID.randomUUID().toString());
        errorCode.setMessage(e.getMessage());
        this.errorCode(errorCode,e);
        return errorCode;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ClientNoFoundException.class)
    public ErrorCode clientNoFoundException(Exception e){
        ErrorCode errorCode = ErrorCode.builder().build();
        errorCode.setCode(UUID.randomUUID().toString());
        errorCode.setMessage(e.getMessage());
        this.errorCode(errorCode,e);
        return errorCode;
    }
}
