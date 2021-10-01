package com.softserve.controller;

import com.softserve.model.Booking;
import com.softserve.model.Hotel;
import com.softserve.model.Room;
import com.softserve.model.User;
import com.softserve.service.BookingService;
import com.softserve.service.HotelService;
import com.softserve.service.RoomService;
import com.softserve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;
    private final HotelService hotelService;
    private final BookingService bookingService;
    private final UserService userService;

    @Autowired
    public RoomController(RoomService roomService, HotelService hotelService, BookingService bookingService, UserService userService) {
        this.roomService = roomService;
        this.hotelService = hotelService;
        this.bookingService = bookingService;
        this.userService = userService;
    }

    @GetMapping("/all/{id}")
    public String getHotelRooms(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("rooms", roomService.getAllHotelRooms(id));
        return "rooms";
    }

    @PreAuthorize("hasAuthority('all_permissions')")
    @GetMapping("/deleteRoom/{id}")
    public String deleteRoom(Model model, @PathVariable("id") Integer id) {
        Hotel hotel = roomService.findByNumber(id).getHotel();
        List<Room> roomList = roomService.getAllHotelRooms(hotel.getId());
        roomService.delete(id);
        model.addAttribute("rooms", roomList);
        return "rooms";
    }

    @PreAuthorize("hasAuthority('all_permissions')")
    @GetMapping("/add/{id}")
    public String addRoom(@PathVariable("id") Integer id, Model model) {
        Hotel hotel = hotelService.findById(id);
        Room room = new Room();
        room.setHotel(hotel);
        model.addAttribute("room", room);
        return "addRoom";
    }

    @PostMapping("/add")
    public String addRoom(@ModelAttribute("hotelId") Integer id, Room room, Model model) {
        Hotel hotel = hotelService.findById(id);
        room.setHotel(hotel);
        roomService.save(room);
        List<Room> roomList = roomService.getAllHotelRooms(room.getHotel().getId());
        model.addAttribute("roomList", roomList);
        return "redirect:/rooms/all/" + room.getHotel().getId();
    }

    @PostMapping("/all/{id}")
    public String allHotelRooms(@PathVariable("id") Integer id, Model model) {
        List<Room> rooms = roomService.getAllRooms(id);
        model.addAttribute("rooms", rooms);
        return "checkRoom";
    }

    @PostMapping("/available_room/{id}")
    public String checkIfRoomAvailableInHotel(@PathVariable(name = "id") Integer roomId,
                                              @RequestParam("checkIn")
                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
                                              @RequestParam("checkOut")
                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut,
                                              @RequestParam(value = "hotelId") Integer hotelId,
                                              Model model) {

        Booking booking = new Booking();
        booking.setCheckIn(checkIn);
        booking.setCheckOut(checkOut);
        booking.setRoom(roomService.findByNumber(roomId));
        boolean isAvailable;
        try {
            isAvailable = roomService.availableRoomsInHotel(booking);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("rooms", roomService.getAllHotelRooms(hotelId));
            return "checkRoom";
        }

        if (isAvailable) {
            model.addAttribute("id", roomId);
            model.addAttribute("checkIn", checkIn);
            model.addAttribute("checkOut", checkOut);
            return "bookRoom";
        } else {
            model.addAttribute("errorMessage", "This room is not available!");
            model.addAttribute("rooms", roomService.getAllHotelRooms(hotelId));
            return "checkRoom";
        }
    }


    @PostMapping("/available_room/{id}/roomBooking")
    public String bookingRoom(@PathVariable("id") Integer id,
                              @RequestParam("checkIn")
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkin,
                              @RequestParam("checkOut")
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkout,
                              Principal principal) {
        User user = userService.findByName(principal.getName());
        Room room = roomService.findByNumber(id);
        Booking booking = new Booking(checkin, checkout, room, user);
        roomService.saveRoomBooking(booking);
        return "redirect:/rooms/successBooking";
    }

    @GetMapping("/successBooking")
    public String getSuccesfullMessage() {
        return "successBooking";
    }
}
