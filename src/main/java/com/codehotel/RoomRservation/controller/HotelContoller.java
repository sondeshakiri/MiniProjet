package com.codehotel.RoomRservation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codehotel.RoomRservation.DTO.HotelDTO;
import com.codehotel.RoomRservation.model.Hotel;

import com.codehotel.RoomRservation.repository.HotelRepository;

@RestController
public class HotelContoller {
	 @Autowired
	    private HotelRepository hotelRepository;
	 
	    @PostMapping("/Hotel")
	    public Hotel newHotel(@RequestBody HotelDTO hotelDTO) {
	        // Calculer hotel_id
	        int hotelId = generateHotelId();
	        
	        // Créer un nouvel hôtel avec l'hotel_id calculé
	        Hotel newHotel = new Hotel();
	        newHotel.setHotel_id(hotelId);
	        newHotel.setName(hotelDTO.getName());
	        newHotel.setAdresse(hotelDTO.getAdresse());
	        newHotel.setEmail(hotelDTO.getEmail());
	        newHotel.setTel(hotelDTO.getTel());
	        
	        // Enregistrer l'hôtel dans la base de données
	        return hotelRepository.save(newHotel);
	    }
	    private int generateHotelId() {
	        // Obtenez l'horodatage actuel en millisecondes
	        long timestamp = System.currentTimeMillis();
	        // Ajoutez un nombre aléatoire pour garantir l'unicité si plusieurs hôtels sont créés en même temps
	        int random = (int) (Math.random() * 1000);
	        // Concaténez le timestamp et le nombre aléatoire pour créer un identifiant unique
	        return (int) (timestamp + random);
	    }

}
