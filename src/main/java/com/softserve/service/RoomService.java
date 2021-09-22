package com.softserve.service;


import com.softserve.dao.RoomDAO;
import com.softserve.model.Booking;
import com.softserve.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomDAO roomDAO;

    @Autowired
    public RoomService(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public Room findById(Integer roomId) {
        return roomDAO.findById(roomId);
    }

    public List<Room> getAllRooms(Integer id) {
        return roomDAO.getAllRooms();
    }

    public List<Room> getAllHotelRooms(Integer hotelId) {
        return roomDAO.getAllHotelRooms(hotelId);
    }

    public List<Booking> getOrderByRoom (Integer roomId) {
        return roomDAO.getOrderByRoom(roomId);
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

    public boolean availableRoomsInHotel(){
        return false;
    }

}
