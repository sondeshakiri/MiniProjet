package com.codehotel.RoomRservation.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.codehotel.RoomRservation.DTO.DateRangeDTO;
import com.codehotel.RoomRservation.DTO.RoomDTO;
import com.codehotel.RoomRservation.model.Room;

public interface RoomService {

    
   
	void updateRoomAvailability(Long roomId, List<DateRangeDTO> availability);
	void deleteRoom(Long roomId);


	Room getRoomById(Long roomId);


	void addRoomToHotel(Long hotelId, Room room);
	void updateRoom(Long roomId, RoomDTO roomDTO);
	List<Room> getAllRooms();
	

}
