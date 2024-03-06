package com.MyApp.countriesProject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "country")
public class Country {

    //Fields of the entity class.
    @Id
    @JsonIgnore
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private String id = UUID.randomUUID().toString();
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "currency_code")
    private String currencyCode;
    @Column(name = "population")
    private String population;
    @Column(name = "capital")
    private String capital;
    @Column(name = "continent_name")
    private String continentName;

    // Constructors
    public Country(){

    }
    public Country(String countryCode, String countryName, String currencyCode, String population, String capital, String continentName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.currencyCode = currencyCode;
        this.population = population;
        this.capital = capital;
        this.continentName = continentName;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }
}
