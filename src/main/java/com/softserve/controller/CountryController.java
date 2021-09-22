package com.softserve.controller;

import com.softserve.model.Country;
import com.softserve.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    CountryController(CountryService service) {
        this.countryService = service;
    }

    @GetMapping("/findHotelByCountry")
    public String findByCountry(Model model) {
        List<Country> countries = countryService.getAllCountries();
        model.addAttribute("countryList", countries);
        return "findByCountry";
    }

    @PostMapping("/findHotelByCountry")
    public String findByCountryName(@RequestParam("name") String country) {
        return "redirect:/findHotelByCountry/" + country;
    }
}

