package com.softserve.dao;

import com.softserve.model.Booking;
import com.softserve.model.Room;

import java.time.LocalDate;
import java.util.List;

public interface RoomDAO {
    Room findByNumber(Integer room_number);
    List<Room> getAllRooms();
    List<Room> getAllHotelRooms(Integer hotelId);
    void save(Room room);
    void delete(Integer id);
    void saveRoomBooking(Booking booking);
    List<Room> getRoomsBookedInHotelOnDate(Integer hotelId, LocalDate checkIn, LocalDate checkOut);
}
