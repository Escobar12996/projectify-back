package com.escobar.Proyectify.service.security.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.escobar.Proyectify.dto.ErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handleAccessDeniedException(BadCredentialsException ex) {
        return new ResponseEntity<>(new ErrorResponse("Bad Credentials Exception."), HttpStatus.UNAUTHORIZED);
    }
}
