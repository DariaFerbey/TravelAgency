package com.softserve.controller;

import com.softserve.model.Hotel;
import com.softserve.model.Room;
import com.softserve.service.HotelService;
import com.softserve.service.RoomService;
import com.softserve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RoomController {
    private final RoomService roomService;
    private final HotelService hotelService;
    private final UserService userService;

    @Autowired
    public RoomController(RoomService roomService, HotelService hotelService, UserService userService) {
        this.roomService = roomService;
        this.hotelService = hotelService;
        this.userService = userService;
    }

    @GetMapping("/allHotelRooms/{id}")
    public String getHotelRooms(Model model, @PathVariable Integer id) {
        model.addAttribute("roomList", roomService.getAllHotelRooms(id));
        return "allHotelRooms";
    }

    @GetMapping("/deleteRoom/{id}")
    public String deleteRoom(Model model, @PathVariable("id") Integer id) {
        Hotel hotel = roomService.findById(id).getHotel();
        List<Room> roomList = roomService.getAllHotelRooms(hotel.getId());
        roomService.delete(id);
        model.addAttribute("roomList", roomList);
        return "allHotelRooms";
    }

    @GetMapping("/addRoom/{id}")
    public String addRoom(@PathVariable("id") Integer id, Model model) {
        Hotel hotel = hotelService.findById(id);
        Room room = new Room();
        room.setHotel(hotel);
        model.addAttribute("room", room);
        return "addRoom";
    }

    @PostMapping("/addRoom")
    public String addRoomForm(Room room, Model model) {
        roomService.save(room);
        List<Room> roomList = roomService.getAllHotelRooms(room.getHotel().getId());
        model.addAttribute("roomList", roomList);
        return "redirect:/allHotelRooms/" + room.getHotel().getId();
    }

    @PostMapping("/allHotelRooms/{id}")
    public String allHotelRooms(@PathVariable("id") Integer id, Model model) {
        List<Room> rooms = roomService.getAllRooms(id);
        model.addAttribute("rooms", rooms);
        return "checkRoom";
    }


    @GetMapping("/successBooking")
    public String getSuccesfullMessage() {
        return "successBooking";
    }
}
