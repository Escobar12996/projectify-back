package com.escobar.Proyectify.service.security.ExceptionHandler;

import com.escobar.Proyectify.config.AppConfig;
import com.escobar.Proyectify.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;
import java.util.ResourceBundle;

@ControllerAdvice
public class CustomExceptionHandler {

    private String getMessage(String key, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle(AppConfig.bundleLocale, locale);
        return bundle.getString(key);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handleBadCredentialsException(BadCredentialsException ex, Locale locale) {
        return new ResponseEntity<>(new ErrorResponse(getMessage("error.bad.credentials", locale)), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccountExpiredException.class)
    public ResponseEntity<Object> handleAccountExpiredException(AccountExpiredException ex, Locale locale) {
        return new ResponseEntity<>(new ErrorResponse(getMessage("error.account.expired", locale)), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(LockedException.class)
    public ResponseEntity<Object> handleLockedException(LockedException ex, Locale locale) {
        return new ResponseEntity<>(new ErrorResponse(getMessage("error.account.locked", locale)), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(CredentialsExpiredException.class)
    public ResponseEntity<Object> handleCredentialsExpiredException(CredentialsExpiredException ex, Locale locale) {
        return new ResponseEntity<>(new ErrorResponse(getMessage("error.credentials.expired", locale)), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex, Locale locale) {
        return new ResponseEntity<>(new ErrorResponse(getMessage("error.internal", locale)), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
