package com.softserve.controller;

import com.softserve.model.Country;
import com.softserve.model.Hotel;
import com.softserve.model.Room;
import com.softserve.service.CountryService;
import com.softserve.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;
    private final CountryService countryService;

    @Autowired
    public HotelController(HotelService hotelService, CountryService countryService) {
        this.hotelService = hotelService;
        this.countryService = countryService;
    }

    @GetMapping("/addHotel")
    public String addHotelPage(Model model) {
        model.addAttribute("hotel",new Hotel());
        model.addAttribute("countryList", countryService.getAllCountries());
        return "addHotel";
    }

    @PostMapping("/addHotel")
    public String addHotelForm(Hotel hotel, @RequestParam("countryName") Integer countryId) {
        hotel.setCountry(countryService.findById(countryId));
        hotelService.save(hotel);
        return "redirect:/hotels/hotelList";
    }

    @GetMapping("/deleteHotel/{id}")
    public String deleteHotel(@PathVariable("id") Integer id) {
        hotelService.delete(id);
        return "redirect:/hotels/hotelList";
    }

    @GetMapping("/hotelList")
    public String hotelListPage(Model model) {
        List<Hotel> hotelList = hotelService.getAllHotels();
        model.addAttribute("hotels", hotelList);
        return "hotelList";
    }

    @GetMapping("/updateHotel/{id}")
    public String updateHotelPage(@PathVariable("id") Integer id, Model model) {
        Hotel hotel = hotelService.findById(id);
        model.addAttribute("hotel", hotel);
        return "update-hotel";
    }

    @PostMapping("/updateHotel/{id}")
    public String updateHotel(@PathVariable Integer id, Hotel hotel) {
        List<Room> list = hotelService.findById(hotel.getId()).getRooms();
        hotel.setRooms(list);
        Country country = hotelService.findById(id).getCountry();
        hotel.setCountry(country);
        hotelService.update(hotel);
        return "redirect:/hotels/hotelList";
    }

    @GetMapping("/findHotel")
    public String get(@RequestParam(required = false) String country, Model model) {
        model.addAttribute("countryList", countryService.getAllCountries());
        Optional<Country> optionalCountry = Optional.ofNullable(countryService.findByName(country));
        if (optionalCountry.isPresent()) {

            List<Hotel> list = hotelService.getAllHotelByCountry(optionalCountry.get().getId());
            if (list.isEmpty()) {
                model.addAttribute("errorMessage", "There is no hotels in " + countryService.findByName(country));
            }
            model.addAttribute("hotels", list);
        } else if (country != null && !country.isEmpty()) {
            model.addAttribute("errorMessage", "There is no hotels in " + countryService.findByName(country));
        }

        return "findByCountry";
    }
}
