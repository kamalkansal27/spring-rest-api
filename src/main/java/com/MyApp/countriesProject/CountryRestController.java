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
    @GetMapping("/check")
    public String check(){
        return "Hi, I am working!";
    }
    @GetMapping("/all")
    public List<Country> getAll(){
        return myCountryService.getAllCountries();
    }

//    @GetMapping("/all?sortBy={param}&order={order}")
//    public List<Country> sort(@PathVariable String param, @PathVariable String order){
//        List<Country> myCountries = myCountryService.getAllCountries();
//        myCountries.sort(Comparator.comparing(param));
//        return myCountries;
//    }
    @GetMapping("/sortA")
    public List<Country> sortA(){
        List<Country> myCountries = myCountryService.getAllCountries();
        myCountries.sort(Comparator.comparing(Country::getPopulation));
        return myCountries;
    }

    @GetMapping("/sortD")
    public List<Country> getAllDescSorted(){
        List<Country> myCountries = myCountryService.getAllCountries();
        myCountries.sort(Comparator.comparing(Country::getPopulation).reversed());
        return myCountries;
    }
}

//    @GetMapping("/getAll")
//    public List<Country> getAll(@RequestParam Optional<String> sort, @RequestParam Optional<String> order){
//
//        if (sort.isPresent() && order.isPresent()){
//            Sort sOder = order.get().equalsIgnoreCase("DESC") ? Sort.by(sort.get()).descending() : Sort.by(sort.get()).ascending();
//            return myCountryService.getAllCountries();
//        }
//        return
//    }