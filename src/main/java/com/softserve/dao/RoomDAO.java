package com.softserve.dao;

import com.softserve.model.Booking;
import com.softserve.model.Room;

import java.util.List;

public interface RoomDAO {
    Room findById(Integer id);
    List<Room> getAllRooms();
    List<Room> getAllHotelRooms(Integer hotelId);
    List<Booking> getOrderByRoom(Integer id);
    void save(Room room);
    void delete(Integer id);
    void saveRoomBooking(Booking booking);
}
