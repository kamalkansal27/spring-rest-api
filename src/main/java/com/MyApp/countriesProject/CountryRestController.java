package com.MyApp.countriesProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    public Country check(@PathVariable String code){
        return myCountryService.getCountryByCountryCode(code);
    }
    @GetMapping("/all")
    public List<Country> getAll(){
        return myCountryService.getAllCountries();
    }

    @GetMapping("/sort")
    public List<Country> getAllSorted(@RequestParam("field") String field, @RequestParam("order") String order){
        return myCountryService.getAllSorted(field, order);
    }
}
