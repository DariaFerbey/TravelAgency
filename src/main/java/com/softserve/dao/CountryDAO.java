package com.softserve.dao;

import com.softserve.model.Country;

import java.util.List;

public interface CountryDAO {
    Country findById(Integer id);
    Country findByName(String name);
    List<Country> getAllCountries();
}
