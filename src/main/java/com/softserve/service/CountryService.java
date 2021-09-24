package com.softserve.service;

import com.softserve.dao.CountryDAO;
import com.softserve.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryService {

    public final CountryDAO countryDAO;

    @Autowired
    public CountryService(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    public Country findById(Integer id) {
        return countryDAO.findById(id);
    }

    public Country findByName(String name) {
        return countryDAO.findByName(name);
    }

    public List<Country> getAllCountries() {
        return countryDAO.getAllCountries();
    }
}
