package com.MyApp.countriesProject;

import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    Country save(Country country);

    List<Country> getAllCountries();

    List<Country> getAllSorted(String field, String order);

    Country getCountryByCountryCode(String code);

    List<Country> findAllInRange(int low, int high);

    List<Country> getCountryByContinentName(String continent);

    List<Country> findAllStartingWithAlpha(String ch);

    List<Country> findAllOfLength(int len);

    List<Country> getCountryByCountryName(String country);
}
