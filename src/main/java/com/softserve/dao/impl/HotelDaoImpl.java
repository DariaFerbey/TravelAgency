package com.softserve.dao.impl;

import com.softserve.dao.HotelDAO;
import com.softserve.model.Hotel;
import com.softserve.model.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Repository
public class HotelDaoImpl implements HotelDAO {

    private final Logger log = LoggerFactory.getLogger(HotelDaoImpl.class);
    private final SessionFactory sessionFactory;

    @Autowired
    public HotelDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Hotel findById(Integer id) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Hotel hotel = session.get(Hotel.class, id);
        log.info("Find hotel by id: " + id);
        return hotel;
    }

    @Override
    public List<Hotel> getAllHotels() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<Hotel> hotels = session.createQuery("from Hotel", Hotel.class)
                .getResultList();
        log.info("Get list of hotels");
        return hotels;
    }

    @Override
    public List<Hotel> getAllHotelsByCountry(Integer countryId) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        log.info("Find hotels from country with id=" + countryId);
        try {
            return session.createQuery("FROM Hotel WHERE id=:country_id", Hotel.class)
                    .setParameter("country_id", countryId)
                    .getResultList();
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("We could not find any hotels in this country");
        }
    }

    @Override
    public void save(Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        session.save(hotel);
        log.info("Save hotel: id=" + hotel.getId());
    }

    @Override
    public void update(Hotel hotel) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        session.update(hotel);
        log.info("Update hotel: id=" + hotel.getId());
    }

    @Override
    public void delete(Integer id) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Hotel hotel = session.get(Hotel.class, id);
        List<Room> rooms = hotel.getRooms();
        for (Room room: rooms) {
            room.setBookings(null);
        }
        log.info("Delete hotel by id" + hotel.getId());
        session.delete(hotel);
    }
}
