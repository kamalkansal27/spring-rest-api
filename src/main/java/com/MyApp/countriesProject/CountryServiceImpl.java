package com.MyApp.countriesProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return myCountryRepository.findAll();
    }

    @Override
    public List<Country> getAllSorted(String field, String order) {
        Sort sortA = Sort.by(Sort.Order.by(field)).ascending();
        Sort sortD = Sort.by(Sort.Order.by(field)).descending();
        return (order.equals("ASC")) ? myCountryRepository.findAll(sortA): myCountryRepository.findAll(sortD);
    }

    @Override
    public Country getCountryByCountryCode(String code) {
        return myCountryRepository.getCountryByCountryCode(code);
    }

    @Override
    public List<Country> findAllInRange(int low, int high) {
        return myCountryRepository.findAllInRange(low, high);
    }

    @Override
    public List<Country> getCountryByContinentName(String continent) {
        return myCountryRepository.getCountryByContinentName(continent);
    }

    @Override
    public List<Country> findAllStartingWithAlpha(String ch) {
        return myCountryRepository.findAllStartingWithAlpha(ch);
    }
}
