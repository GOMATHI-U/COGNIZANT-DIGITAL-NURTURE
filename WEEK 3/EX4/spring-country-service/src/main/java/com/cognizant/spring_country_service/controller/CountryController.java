package com.cognizant.spring_country_service.controller;

import com.cognizant.spring_country_service.model.Country;
import com.cognizant.spring_country_service.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {

        System.out.println("START - getCountry()");

        Country country = countryService.getCountry(code);

        System.out.println("END - getCountry()");

        return country;
    }
}