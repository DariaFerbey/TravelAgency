package com.softserve.controller;

import com.softserve.service.BookingService;
import com.softserve.service.RoomService;
import com.softserve.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;
    private final UserService userService;
    private final RoomService roomService;

    public BookingController(BookingService bookingService, UserService userService, RoomService roomService) {
        this.bookingService = bookingService;
        this.userService = userService;
        this.roomService = roomService;
    }

    @GetMapping("/delete/{id}")
    public String cancelBooking(@PathVariable("id") Integer bookingId) {
        Integer userId = bookingService.getBookingById(bookingId).getUser().getId();
        bookingService.cancel(bookingId);
        return "redirect:/booking/all/" + userId;
    }

    @PreAuthorize("hasAuthority('all_permissions')")
    @GetMapping("/all/{id}")
    public String getAllBookingsByUserId(@PathVariable("id") Integer userId, Model model) {
        model.addAttribute("all", bookingService.getBookingsByUserId(userId));
        model.addAttribute("user", userService.findById(userId));
        return "bookings-list";
    }
}
