package com.MyApp.countriesProject;

import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    Country save(Country country);
//    List<Country> getAllCountries(Optional<Sort> sOder);

    List<Country> getAllCountries();
}
