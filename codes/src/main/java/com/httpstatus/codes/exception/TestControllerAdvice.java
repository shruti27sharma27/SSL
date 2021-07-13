package com.httpstatus.codes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ControllerAdvice controller, which is used to set up how Spring Boot manages exceptions:
 */
@ControllerAdvice
@ResponseBody
public class TestControllerAdvice {

    @ExceptionHandler(CaughtCustomException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(CaughtCustomException exception) {
        return String.format("The HTTP Status will be Internal Server Error (CODE 500)\n %s\n",exception.getMessage()) ;
    }
}
