package com.MyApp.countriesProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/country")
public class CountryRestController {
    private final CountryService myCountryService;
    @Autowired
    CountryRestController(CountryService theCountryService){
        myCountryService = theCountryService;
    }
    @GetMapping("/{code}")
    public Country getCountryByCountryCode(@PathVariable String code){
        Country res = myCountryService.getCountryByCountryCode(code);
        if(res == null) throw new CountryNotFoundException("Country with code - " + code + " is not Present");
        else return res;
    }
    @GetMapping("/all")
    public List<Country> getAll(){
        return myCountryService.getAllCountries();
    }
    @GetMapping("/sort")
    public List<Country> getAllSorted(@RequestParam("field") String field, @RequestParam("order") String order){
        if(!order.equals("ASC") && !order.equals("DESC")) throw new CountryBadRequestException("Parameter sent in URL are not valid");
        else if(!field.equals("countryCode") && !field.equals("countryName") && !field.equals("currencyCode") && !field.equals("population") && !field.equals("capital") && !field.equals("continentName")) throw new CountryBadRequestException("Parameter sent in URL are not valid");
        return myCountryService.getAllSorted(field, order);
    }
    @GetMapping("/range")
    public List<Country> getAllInRange(@RequestParam("low") int low, @RequestParam("high") int high){
        return myCountryService.findAllInRange(low, high);
    }
    @GetMapping("/continent/{CName}")
    public List<Country> getCountriesByContinentName(@PathVariable("CName") String CName){
        return myCountryService.getCountryByContinentName(CName);
    }
    @GetMapping("/starting/{ch}")
    public List<Country> getCountriesStartingWithAlpha(@PathVariable("ch") String ch){
        return myCountryService.findAllStartingWithAlpha(ch);
    }
    @GetMapping("/length/{len}")
    public List<Country> getCountriesWithLength(@PathVariable("len") int len){
        return myCountryService.findAllOfLength(len);
    }
    @GetMapping("/name/{country}")
    public List<Country> getCountryByCountryName(@PathVariable("country") String country){
        return myCountryService.getCountryByCountryName(country);
    }

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
