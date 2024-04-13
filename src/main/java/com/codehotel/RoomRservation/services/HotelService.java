package com.codehotel.RoomRservation.services;

import com.codehotel.RoomRservation.DTO.HotelDTO;
import com.codehotel.RoomRservation.model.Hotel;
import com.codehotel.RoomRservation.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public HotelDTO findHotelByName(String hotelName) {
        return hotelRepository.findByName(hotelName);
    }
}
