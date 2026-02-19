package com.geisivan.notificacao.infraStructure;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<String> handleApiException(ApiException exception) {
        return ResponseEntity
                .status(exception.getStatus())
                .body(exception.getMessage());
    }
}
