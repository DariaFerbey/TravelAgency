package com.softserve.dao.impl;

import com.softserve.dao.BookingDAO;
import com.softserve.model.Booking;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingDaoImpl implements BookingDAO {

    private final Logger log = LoggerFactory.getLogger(CountryDaoImpl.class);
    private  final SessionFactory sessionFactory;

    public BookingDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Booking booking) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        session.save(booking);
        log.info("Save booking by id: "+ booking.getId());
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Booking booking = session.get(Booking.class, id);
        log.info("Delete booking by id: " + id);
        session.delete(booking);
    }

    @Override
    public Booking getByUserId(Integer id) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Booking booking = session.get(Booking.class, id);
        log.info("Get list of all bookings by user id (user_id: "+ id+"): ");
        return booking;
    }

    @Override
    public Booking getByRoomNumber(Integer roomNumber) {
        Session session = sessionFactory.getCurrentSession();
        Booking booking = session.createQuery("from Booking  b where b.room.number=:roomNumber", Booking.class)
                .setParameter("roomNumber",roomNumber)
                .getResultList()
                .stream().findFirst().orElse(null);
        return booking;
    }

    @Override
    public List<Booking> getAllBookings() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<Booking> bookings = session.createQuery("select booking from Booking  booking", Booking.class)
                .getResultList();
        log.info("Get list of bookings");
        return bookings;
    }
}
