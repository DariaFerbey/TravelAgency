package com.softserve.dao.impl;

import com.softserve.dao.CountryDAO;
import com.softserve.model.Country;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDAO {

    private final Logger log = LoggerFactory.getLogger(CountryDaoImpl.class);
    private  final SessionFactory sessionFactory;

    @Autowired
    public CountryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Country findById(Integer id) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Country country = session.get(Country.class, id);
        log.info("Find country by id " + country);
        return country;
    }

    @Override
    public Country findByName(String name) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Country country = session.createQuery("from Country c where c.name=:name",Country.class)
                .setParameter("name",name)
                .getSingleResult();
        log.info("Find country by name "+country.getName());
        return country;
    }

    @Override
    public List<Country> getAllCountries() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<Country> countries = session.createQuery("from Country",Country.class)
                .getResultList();

        log.info("Get list of countries " + countries);
        return countries;
    }
}
