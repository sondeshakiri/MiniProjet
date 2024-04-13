package com.codehotel.RoomRservation.controller;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.codehotel.RoomRservation.model.Room;
import com.codehotel.RoomRservation.model.RoomReservationRequest;
import com.codehotel.RoomRservation.services.ReservationchambreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/Reservation")
@Api(tags = "Room Reservation", description = "Endpoints for room reservation")

public class ReservationchambreController {
	@Autowired
	private ReservationchambreService reservationService;
	

	
	@PostMapping("/reserve/{userId}")
    @ApiOperation(value = "Reserve a room", notes = "Provide room reservation details and user ID to reserve a room")	    public ResponseEntity<String> reserveRoom(@RequestBody RoomReservationRequest request, @PathVariable Long userId) {
	        boolean reservationSuccess = reservationService.reserveRoom(request, userId);
	        if (reservationSuccess) {
	            return ResponseEntity.ok("Room reserved successfully!");
	        } else {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to reserve room. Please try again.");
	        }
	    }

	
	 @GetMapping("/searchRooms")
	 @ApiOperation(value = "Search available rooms", notes = "Provide start date, end date, and capacity to search for available rooms")
	 public ResponseEntity<?> searchRooms(
	         @RequestParam("startDate") Date startDate,
	         @RequestParam("endDate") Date endDate,
	         @RequestParam("capacity") int capacity) {

	     

	     // Appeler le service de recherche de chambres
	     List<Room> availableRooms = reservationService.searchAvailableRoomm(startDate,endDate, capacity);
	     // Vérifier si des chambres sont disponibles
	     if (availableRooms.isEmpty()) {
	    	 String message = "Aucune chambre disponible pour les dates spécifiées.";
	         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	     } else {
	         return ResponseEntity.ok(availableRooms);
	     }
	 }

}
