package com.softserve.service;

import com.softserve.dao.HotelDAO;
import com.softserve.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotelService {

    private final HotelDAO hotelDAO;

    @Autowired
    public HotelService(HotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }

    public Hotel findById(Integer id) {
        return hotelDAO.findById(id);
    }

    public List<Hotel> getAllHotels() {
        return hotelDAO.getAllHotels();
    }

    public List<Hotel> getAllHotelByCountry(Integer country_id) {
        return hotelDAO.getAllHotelsByCountry(country_id);
    }

    public void save(Hotel hotel) {
        hotelDAO.save(hotel);
    }

    public void update(Hotel hotel) {
        hotelDAO.update(hotel);
    }

    public void delete(Integer hotelId) {
        hotelDAO.delete(hotelId);
    }
}
