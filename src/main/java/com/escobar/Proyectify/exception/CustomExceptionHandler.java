package com.escobar.Proyectify.exception;

import com.escobar.Proyectify.config.AppConfig;
import com.escobar.Proyectify.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@ControllerAdvice
public class CustomExceptionHandler {

    private String getMessage(String key, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle(AppConfig.bundleLocale, locale);
        return bundle.getString(key);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidation(MethodArgumentNotValidException ex, Locale locale) {
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(String.join(", ", errors)));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handleBadCredentials(BadCredentialsException ex, Locale locale) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorResponse(getMessage("error.bad.credentials", locale)));
    }

    @ExceptionHandler(AccountExpiredException.class)
    public ResponseEntity<Object> handleAccountExpired(AccountExpiredException ex, Locale locale) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorResponse(getMessage("error.account.expired", locale)));
    }

    @ExceptionHandler(LockedException.class)
    public ResponseEntity<Object> handleLocked(LockedException ex, Locale locale) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorResponse(getMessage("error.account.locked", locale)));
    }

    @ExceptionHandler(CredentialsExpiredException.class)
    public ResponseEntity<Object> handleCredentialsExpired(CredentialsExpiredException ex, Locale locale) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorResponse(getMessage("error.credentials.expired", locale)));
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Object> handleUsernameNotFound(UsernameNotFoundException ex, Locale locale) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorResponse(getMessage("error.account.notFound", locale)));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneric(Exception ex, Locale locale) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(getMessage("error.internal", locale)));
    }
}
