package com.martin.urlshortener.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadUrlException extends Exception{
    public BadUrlException() {}
    public BadUrlException(String message) {
        super(message);
    }
}
