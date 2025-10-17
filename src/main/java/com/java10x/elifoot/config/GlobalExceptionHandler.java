package com.java10x.elifoot.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.java10x.elifoot.exception.ResourceAlreadyExistException;
import com.java10x.elifoot.exception.ResourceNotFoundException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> fieldErrors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            fieldErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorResponse error = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Validation error")
                .errors(fieldErrors)
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponse error = ErrorResponse.builder()
                    .timestamp(LocalDateTime.now())
                    .message(ex.getMessage())
                    .status(HttpStatus.NOT_FOUND.value())
                    .build();

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleBadCredentials(BadCredentialsException ex) {
        ErrorResponse error = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAcessDenied(AccessDeniedException ex) {
        ErrorResponse error = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .status(HttpStatus.FORBIDDEN.value())
                .build();

        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);

    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleResourceAlreadyExist(ResourceNotFoundException ex) {
        ErrorResponse error = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .status(HttpStatus.CONFLICT.value())
                .build();

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    @Getter
    @Setter
    @Builder
    public static class ErrorResponse{
        private LocalDateTime timestamp;
        private int status;
        private String message;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Map<String, String> errors;


    }
}
