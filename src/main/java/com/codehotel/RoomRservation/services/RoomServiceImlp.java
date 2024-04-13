package com.codehotel.RoomRservation.services;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.codehotel.RoomRservation.DTO.DateRangeDTO;

import com.codehotel.RoomRservation.DTO.RoomDTO;
import com.codehotel.RoomRservation.model.DateRange;
import com.codehotel.RoomRservation.model.Hotel;
import com.codehotel.RoomRservation.model.Photo;
import com.codehotel.RoomRservation.model.Room;
import com.codehotel.RoomRservation.repository.HotelRepository;
import com.codehotel.RoomRservation.repository.RoomRepository;

@Service
public class RoomServiceImlp implements RoomService {


	 
    @Autowired
    private final HotelRepository hotelRepository;
    
    @Autowired
    private final RoomRepository roomRepository;

    public RoomServiceImlp(HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public void addRoomToHotel(Long hotelId, Room room) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        room.setNumR(room.getNumR());
        room.setPrice(room.getPrice());
        room.setCapacity(room.getCapacity());
        room.setType(room.getType());
        room.setAmenities(room.getAmenities());
        int roomId = (int) (room.getNumR() * 10 + room.getNumR());
        room.setRoom_id(roomId);
        room.setHotel(hotel);
        
        if (room.getPhotos() != null) {
            List<Photo> photos = room.getPhotos().stream()
                                        .map(photoDTO -> {
                                            Photo photo = new Photo();
                                            photo.setUrl(photoDTO.getUrl());
                                            photo.setDescription(photoDTO.getDescription());
                                            photo.setRoom(room); 
                                            return photo;
                                        })
                                        .collect(Collectors.toList());
            room.setPhotos(photos);
        };
     // Associer chaque période de dates à la chambre
        if (room.getDaterange() != null) {
            for (DateRange dateRange : room.getDaterange()) {
                dateRange.setRoom(room);
            }
        }
        
        
        
        roomRepository.save(room);
    }
    

	   
	   


    @Override
    public void updateRoomAvailability(Long roomId, List<DateRangeDTO> availability) {
        // Recherche de la chambre avec l'ID donné
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + roomId));

        // Mise à jour de la disponibilité de la chambre avec la nouvelle liste de plages de dates
        List<DateRange> dateRanges = availability.stream()
                .map(dateRangeDTO -> {
                    DateRange dateRange = new DateRange();
                    dateRange.setStartDate(dateRangeDTO.getStartDate());
                    dateRange.setEndDate(dateRangeDTO.getEndDate());
                    dateRange.setRoom(room);
                    return dateRange;
                })
                .collect(Collectors.toList());

        // Supprimer les anciennes plages de dates de la chambre
        room.getDaterange().clear();

        // Ajouter les nouvelles plages de dates à la chambre
        room.getDaterange().addAll(dateRanges);

        // Enregistrer les modifications dans la base de données
        roomRepository.save(room);
    }
    
    
    

	@Override
	public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);
    }

	@Override
	 public Room getRoomById(Long roomId) {
        return roomRepository.findById(roomId).orElse(null);
    }

	@Override
	 public void updateRoom(Long roomId, RoomDTO roomDTO) {
        // Recherche de la chambre existante par son ID
        Room existingRoom = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + roomId));

        // Mettre à jour les champs de la chambre avec les valeurs fournies dans le DTO
        existingRoom.setNumR(roomDTO.getNumR());
        existingRoom.setPrice(roomDTO.getPrice());
        existingRoom.setCapacity(roomDTO.getCapacity());
        existingRoom.setType(roomDTO.getType());
        existingRoom.setAmenities(roomDTO.getAmenities());
        // Mettre à jour d'autres champs si nécessaire

        // Enregistrer les modifications dans la base de données
        roomRepository.save(existingRoom);
    }
	
	

	@Override
	public List<Room> getAllRooms() {
		List<Room> rooms=roomRepository.findAll();
		
		if (rooms==null) {
			System.out.println("mathama hatta room");
			return null;
		}
		else {
			return rooms;
		}
        
    }

}
