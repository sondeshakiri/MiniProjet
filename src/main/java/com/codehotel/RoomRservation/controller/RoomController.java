package com.codehotel.RoomRservation.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codehotel.RoomRservation.DTO.DateRangeDTO;
import com.codehotel.RoomRservation.DTO.HotelDTO;
import com.codehotel.RoomRservation.DTO.RoomDTO;
import com.codehotel.RoomRservation.model.Hotel;
import com.codehotel.RoomRservation.model.Room;
import com.codehotel.RoomRservation.services.HotelService;
import com.codehotel.RoomRservation.services.RoomService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/Rooms")
@Api(tags = "Room Management", description = "Endpoints for managing rooms")

public class RoomController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private HotelService hotelService;
    

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addrooms/{hotelId}")
    @ApiOperation(value = "Add a room to a hotel", notes = "Provide hotelId and room details to add a room to a hotel")    public ResponseEntity<String> addRoomToHotel(@PathVariable Long hotelId, @RequestBody Room room) {
        roomService.addRoomToHotel(hotelId, room);
        return ResponseEntity.status(HttpStatus.CREATED).body("Room added to hotel successfully");
    }
    

    @PutMapping("updateRoom/{roomId}")
    @ApiOperation(value = "Update room details", notes = "Provide roomId and room details to update the room")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> updateRoom(@PathVariable Long roomId, @RequestBody RoomDTO roomDTO) {
        try {
            roomService.updateRoom(roomId, roomDTO);
            return ResponseEntity.ok("Room updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{roomId}")
    @ApiOperation(value = "Delete a room", notes = "Provide roomId to delete a room")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteRoom(@PathVariable Long roomId) {
    	 try {
    		 roomService.deleteRoom(roomId);
             return ResponseEntity.ok(" la chambre a été supprimer avec succès.");
         } catch (IllegalArgumentException e) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La chambre avec l'identifiant donné n'existe pas.");
         }
    }
    
    @PatchMapping("/availability/{roomId}")
    @ApiOperation(value = "Update room availability", notes = "Provide roomId and list of date ranges to update room availability")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateRoomAvailability(@PathVariable Long roomId, @RequestBody List<DateRangeDTO> availability) {
        try {
            roomService.updateRoomAvailability(roomId, availability);
            return ResponseEntity.ok("La disponibilité de la chambre a été mise à jour avec succès.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
    @GetMapping("/allRooms")
    @ApiOperation(value = "Get all rooms", notes = "Retrieve all rooms")
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        if (rooms==null)
        {
			System.out.println("maraj3t hatta room");

        	return null;
        }
		System.out.println("raj3t room");

        return ResponseEntity.ok(rooms);
    }
    
}
