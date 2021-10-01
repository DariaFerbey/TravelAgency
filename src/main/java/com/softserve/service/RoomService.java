package com.softserve.service;


import com.softserve.dao.RoomDAO;
import com.softserve.model.Booking;
import com.softserve.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class RoomService {

    private final RoomDAO roomDAO;

    @Autowired
    public RoomService(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public Room findByNumber(Integer roomNumber) {
        return roomDAO.findByNumber(roomNumber);
    }

    public List<Room> getAllRooms(Integer id) {
        return roomDAO.getAllRooms();
    }

    public List<Room> getAllHotelRooms(Integer hotelId) {
        return roomDAO.getAllHotelRooms(hotelId);
    }

    public void save(Room room) {
        roomDAO.save(room);
    }

    public void delete(Integer roomId) {
        roomDAO.delete(roomId);
    }

    public void saveRoomBooking(Booking booking) {
        roomDAO.saveRoomBooking(booking);
    }

    public boolean availableRoomsInHotel(Booking booking){
        if(booking.getCheckIn().isEqual(booking.getCheckOut()) ||
        booking.getCheckIn().isAfter(booking.getCheckOut()) ||
        booking.getCheckIn().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Your time borders is not correct.");
        }

        List<Room> booked = roomDAO.getRoomsBookedInHotelOnDate(booking.getRoom().getHotel().getId(), booking.getCheckIn(), booking.getCheckOut());
        return  !booked.contains(roomDAO.findByNumber(booking.getRoom().getNumber()));
    }

}
