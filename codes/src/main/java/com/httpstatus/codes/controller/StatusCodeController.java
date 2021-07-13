package com.httpstatus.codes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@ResponseBody
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class StatusCodeController {

    @GetMapping("/classlevel")
    public String serviceUnavaliable(){
        return "OK";
    }

    @GetMapping("/methodlevel")
    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "Ok")
    public String methodLevel(){
        return "OK";
    }

    @GetMapping("/methodlevelNotFound")
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Resource was not found on the server")
    public String notFound() {
        return "";
    }

}