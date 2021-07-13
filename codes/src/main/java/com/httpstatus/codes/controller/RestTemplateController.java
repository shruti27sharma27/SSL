package com.httpstatus.codes.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.httpstatus.dto.UnicornDTO;
import com.httpstatus.dto.UnicornResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class RestTemplateController {

    // thread-safe
    @Autowired
    RestTemplate restTemplate;

    //ResponseEntity a generic class to encapsulate the status code of the HTTP response,
    // the HTTP headers and an returned data
    @PostMapping(value = "/unicornsByEntity",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UnicornResponse> createEntityUnicorn(@RequestBody UnicornDTO unicornDTO) throws RestClientException, JsonProcessingException {
        return restTemplate.postForEntity("https://crudcrud.com/api/72dbefb3917c4ce1b7bb17776fcf98e9/unicorns",
                unicornDTO, UnicornResponse.class);
    }

    //postForObject() returns object UnicornResponse

    //getForEntity() and getForObject()

    @GetMapping("/unicornsByEntity/{id}")
    public ResponseEntity<String> getUnicornByIdByEntity(@PathVariable final String id) {
        return restTemplate.getForEntity(
                "https://crudcrud.com/api/72dbefb3917c4ce1b7bb17776fcf98e9/unicorns/" + id,
                String.class);
    }

    @GetMapping("/unicornsByObject")
    public List<UnicornResponse> getUnicornByObject() {
        return Arrays.asList(restTemplate.getForObject("https://crudcrud.com/api/72dbefb3917c4ce1b7bb17776fcf98e9/unicorns",
                UnicornResponse[].class));
    }
    @PutMapping(value = "/unicorns/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUnicorn(@PathVariable final String id, @RequestBody UnicornDTO unicornDto) {
        restTemplate.put(
                "https://crudcrud.com/api/72dbefb3917c4ce1b7bb17776fcf98e9/unicorns/" + id,
                unicornDto);
    }

    //It deletes the resource targeted by a URL with an ID being passed as the parameter. Thus, it just expects the URL to be passed and doesn't return any response:
    @DeleteMapping("/unicorns/{id}")
    public void deleteteUnicornByIdByEntity(@PathVariable final String id) {
        restTemplate.delete("https://crudcrud.com/api/72dbefb3917c4ce1b7bb17776fcf98e9/unicorns/" + id);
    }

    //It's a generalization of any HTTP exchange.
    //
    //This means that it can be used for any HTTP call
    //exchange() method returns a ResponseEntity and accepts a RequestEntity - which is constituted by an HTTP method, URL, headers and body - and a ResponseType.

    @PutMapping(value = "/unicorn/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUnicorn1(@PathVariable final String id, @RequestBody UnicornDTO unicornDto) {
        restTemplate.exchange(
                "https://crudcrud.com/api/72dbefb3917c4ce1b7bb17776fcf98e9/unicorns/" + id,
                HttpMethod.PUT,
                new HttpEntity<>(unicornDto),
                Void.class);
    }

//Passing Pre-Defined Headers Using RestTemplate
    //These headers mostly resemble Authentication or Authorization key-value pairs or cookies. They can also be used to set acceptable content types or formats to consume the response data

}
