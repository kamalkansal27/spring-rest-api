package com.MyApp.countriesProject;

import aj.org.objectweb.asm.Type;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class CountriesProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountriesProjectApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(CountryService countryService){
		return args -> {
			// read JSON and load json
			System.out.println("Countries data is being loaded into the database");
			String json = "/countries.json";
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Country>> typeReference = new TypeReference<List<Country>>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream(json);
			try {
				List<Country> countries = mapper.readValue(inputStream, typeReference);
				for(Country country: countries){
					countryService.save(country);
				}
				System.out.println("All the countries are saved");
			} catch (Exception e){
				System.out.println("Unable to save the countries!");
			}

		};
	}
}
