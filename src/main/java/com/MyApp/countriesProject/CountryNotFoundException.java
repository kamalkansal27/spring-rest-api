package com.MyApp.countriesProject;

public class CountryNotFoundException extends RuntimeException{
    CountryNotFoundException(String message){
        super(message);
    }
}
