package com.bsi.bsi.advice;

import com.bsi.bsi.exception.AccountBsiNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class AccountBsiNotFoundHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(AccountBsiNotFoundException.class)
    public Map<String, Object> handleNikNotFoundException(AccountBsiNotFoundException ex) {
        return Map.of(
                "message", ex.getMessage(),
                "status", HttpStatus.NOT_FOUND
        );
    }
}
