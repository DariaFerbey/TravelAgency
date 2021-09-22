package com.softserve.dao;

import com.softserve.model.Hotel;

import java.util.List;

public interface HotelDAO {
    Hotel findById(Integer id);
    List<Hotel> getAllHotels();
    List<Hotel> getAllHotelsByCountry(Integer countryId);
    void save(Hotel hotel);
    void update(Hotel hotel);
    void delete(Integer id);
}
