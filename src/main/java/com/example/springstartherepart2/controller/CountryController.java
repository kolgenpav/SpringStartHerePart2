package com.example.springstartherepart2.controller;

import com.example.springstartherepart2.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/france")
    public Country france() {
        Country country = Country.of("France", 67);
        return country;
    }

    @GetMapping("/francemod")
    public ResponseEntity<Country> franceMod() {
        Country country = Country.of("France", 67);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent", "Europe")
                .header("capital", "Paris")
                .header("favorite_food", "cheese and wine")
                .body(country);
    }

    @GetMapping("/all")
    public List<Country> countries() {
        Country country1 = Country.of("France", 67);
        Country country2 = Country.of("Spain", 47);
        return List.of(country1, country2);
    }
}
