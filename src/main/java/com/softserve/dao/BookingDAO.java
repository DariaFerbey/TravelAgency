package com.softserve.dao;

import com.softserve.model.Booking;

import java.util.List;

public interface BookingDAO {
    void save(Booking booking);
    void delete(Integer id);
    Booking getByUserId(Integer id);
    Booking getByRoomNumber(Integer roomNumber);
    List<Booking> getAllBookings();
}

