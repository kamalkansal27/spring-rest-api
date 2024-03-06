package com.MyApp.countriesProject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CountryControllerAdvice {
    @ExceptionHandler
    ResponseEntity<CountryErrorResponse> handleNotFoundException(CountryNotFoundException exception){
        CountryErrorResponse countryErrorResponse = new CountryErrorResponse();
        countryErrorResponse.setMessage(exception.getMessage());
        countryErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(countryErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    ResponseEntity<CountryErrorResponse> handleBadRequestException(CountryBadRequestException exception){
        CountryErrorResponse countryErrorResponse = new CountryErrorResponse();
        countryErrorResponse.setMessage(exception.getMessage());
        countryErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(countryErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
