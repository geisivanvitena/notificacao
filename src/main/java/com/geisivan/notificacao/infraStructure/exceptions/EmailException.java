package com.geisivan.notificacao.infrastructure.exceptions;

import org.springframework.http.HttpStatus;

public class EmailException extends ApiException{

    public EmailException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    public EmailException(String message, Throwable cause) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR, cause);
    }
}
