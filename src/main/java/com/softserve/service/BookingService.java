package com.softserve.service;

import com.softserve.dao.BookingDAO;
import com.softserve.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookingService {

    private final BookingDAO bookingDao;
    private final RoomService roomService;

    @Autowired
    public BookingService(BookingDAO bookingDao, RoomService roomService) {
        this.bookingDao = bookingDao;
        this.roomService = roomService;
    }

    public void book(Booking booking){
    }

    public void cancel(Integer id){
        bookingDao.delete(id);
    }

    public Booking getBookingById(Integer id){
        return bookingDao.getByUserId(id);
    }

    public List<Booking> getBookingsByUserId(Integer id){
        List<Booking> bookingList = bookingDao.getAllBookings();
        return bookingList.stream()
                .filter(booking -> booking.getUser().getId().equals(id))
                .collect(Collectors.toList());
    }

    public List<Booking> getAllBookings(){
        return bookingDao.getAllBookings();
    }
}
