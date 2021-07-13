package com.httpstatus.codes.controller;

import com.httpstatus.codes.exception.CaughtCustomException;
import com.httpstatus.codes.exception.UnCaughtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@ResponseBody
public class ResponseEntityController {

    @GetMapping("/response_entity")
    public ResponseEntity<String> withResponseEntity() {
        return ResponseEntity.status(HttpStatus.CREATED).body("HTTP Status will be CREATED (CODE 201)\n");
    }

    //Returning Response Status Codes with ResponseStatusException
    //A class used to return status codes in exceptional cases is the ResponseStatusException class.
    // It is used to return a specific message and the HTTP status code that will be returned when an error occurs.
    // It is an alternative to using @ExceptionHandler and @ControllerAdvice. Exception handling using ResponseStatusException is considered to be more fine-grained.
    // It avoids the creation of unnecessary additional Exception classes and reduces tight coupling between the status codes and the exception classes
    @GetMapping("/rse")
    public String withResponseStatusException() {
        try {
            throw new RuntimeException("Error Occurred");
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "HTTP Status will be NOT FOUND (CODE 404)\n");
        }
    }

    //Custom Exception Classes and Returning HTTP Status Codes
    @GetMapping("/caught")
    public String caughtException() {
        throw new CaughtCustomException("Caught Exception Thrown\n");
    }

    @GetMapping("/uncaught")
    public String unCaughtException() {
        throw new UnCaughtException("The HTTP Status will be BAD REQUEST (CODE 400)\n");
    }

}
