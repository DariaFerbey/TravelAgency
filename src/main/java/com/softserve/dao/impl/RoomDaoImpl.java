package com.softserve.dao.impl;

import com.softserve.dao.RoomDAO;
import com.softserve.model.Booking;
import com.softserve.model.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Repository
public class RoomDaoImpl implements RoomDAO {

    private final Logger log = LoggerFactory.getLogger(RoomDaoImpl.class);
    private final SessionFactory sessionFactory;

    @Autowired
    public RoomDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Room findByNumber(Integer room_number) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Room room = session.get(Room.class, room_number);
        log.info("Find room by id: " + room_number);
        return room;
    }

    @Override
    public List<Room> getAllRooms() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<Room> rooms = session.createQuery("select room from Room room", Room.class)
                .getResultList();
        log.info("Get list of rooms");
        return rooms;
    }

    @Override
    public List<Room> getAllHotelRooms(Integer hotelId) {
        Session session = sessionFactory.getCurrentSession();
        List<Room> rooms = session.createQuery("from Room r where hotel.id=:id", Room.class)
                .setParameter("id", hotelId)
                .getResultList();
        log.info("Get list of all rooms in hotel (hotel_id: " + hotelId + "): ");
        return rooms;
    }

    @Override
    public void save(Room room) {
        Session session = sessionFactory.getCurrentSession();
        session.save(room);
        session.save(room);
        log.info("Save room with number" + room.getNumber());

    }

    @Override
    public void delete(Integer id) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Room room = session.get(Room.class, id);
        log.info("Delete room by id: " + id);
        session.delete(room);
    }

    @Override
    public void saveRoomBooking(Booking booking) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        session.save(booking);
        log.info("Save room booking");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Room> getRoomsBookedInHotelOnDate(Integer hotelId, LocalDate checkIn, LocalDate checkOut) {
        Session session = sessionFactory.getCurrentSession();
        List<Room> roomsOnDate = session.createQuery("select b.room from Booking b where (b.checkIn <= :checkIn and  b.checkOut >= :checkOut) and b.room.hotel.id = :hotelId")
                .setParameter("checkIn", checkIn)
                .setParameter("checkOut", checkOut)
                .setParameter("hotelId", hotelId)
                .getResultList();
        return roomsOnDate;
    }

}
