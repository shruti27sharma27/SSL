package com.httpstatus.codes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnCaughtException extends RuntimeException {
    public UnCaughtException(String message) {
        super(message);
    }
}
