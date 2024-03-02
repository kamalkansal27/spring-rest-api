package com.MyApp.countriesProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String>{

    public Country getCountryByCountryCode(String countryCode);

    @Query(
            value = "SELECT * FROM country c WHERE c.population BETWEEN :low AND :high",
            nativeQuery = true
    )
    List<Country> findAllInRange(@Param("low") int low, @Param("high") int high);

    public List<Country> getCountryByContinentName(String continent);

    @Query(
            value = "SELECT * FROM country c where c.country_name LIKE :ch%",
            nativeQuery = true
    )
    List<Country> findAllStartingWithAlpha(String ch);

}
