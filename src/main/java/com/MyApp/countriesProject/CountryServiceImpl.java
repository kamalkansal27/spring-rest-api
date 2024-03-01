package com.MyApp.countriesProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService{
    private final CountryRepository myCountryRepository;
    @Autowired
    public CountryServiceImpl(CountryRepository theCountryRepository){
        myCountryRepository = theCountryRepository;
    }
    @Override
    public Country save(Country country) {
        return (Country) myCountryRepository.save(country);
    }

    @Override
    public List<Country> getAllCountries() {
      //  Sort sort = Sort.by(Sort.Order.by("population")).ascending();
//        sOder.ifPresent(return myCountryRepository.findAll(sOder))
        ;
        return myCountryRepository.findAll();
    }
}
