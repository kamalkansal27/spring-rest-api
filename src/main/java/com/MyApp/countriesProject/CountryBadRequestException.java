package com.MyApp.countriesProject;

public class CountryBadRequestException extends RuntimeException{
    CountryBadRequestException(String message){
        super(message);
    }
}
