package com.escobar.Proyectify.service.security.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.escobar.Proyectify.dto.ErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handleAccessDeniedException(BadCredentialsException ex) {
        return new ResponseEntity<>(new ErrorResponse("Bad credentials"), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccountExpiredException.class)
    public ResponseEntity<Object> handleAccessDeniedException(AccountExpiredException ex) {
        return new ResponseEntity<>(new ErrorResponse("User account has expired"), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(LockedException.class)
    public ResponseEntity<Object> handleAccessDeniedException(LockedException ex) {
        return new ResponseEntity<>(new ErrorResponse("User account is locked"), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(CredentialsExpiredException.class)
    public ResponseEntity<Object> handleAccessDeniedException(CredentialsExpiredException ex) {
        return new ResponseEntity<>(new ErrorResponse("User credentials have expired"), HttpStatus.UNAUTHORIZED);
    }
}
