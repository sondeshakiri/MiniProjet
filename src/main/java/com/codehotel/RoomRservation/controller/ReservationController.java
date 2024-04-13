package com.codehotel.RoomRservation.controller;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codehotel.RoomRservation.services.RservationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.codehotel.RoomRservation.model.*;

@RestController
@RequestMapping("/reservations")
@Api(tags = "Reservation Management", description = "Endpoints for managing reservations")

public class ReservationController {

    @Autowired
    private RservationService reservationService;
    

    // Endpoint pour récupérer l'historique des réservations d'un utilisateur
    @GetMapping("/user/{userId}")
    @ApiOperation(value = "Get user reservations", notes = "Retrieve the reservation history of a user by user ID")

    public ResponseEntity<List<Reservation>> getUserReservations(@PathVariable Long userId) {
        List<Reservation> userReservations = reservationService.getUserReservations(userId);
        return ResponseEntity.ok(userReservations);
    }
    
    
/*
    // Endpoint pour mettre à jour les détails d'une réservation par un utilisateur
    @PutMapping("/{reservationId}")
    @ApiOperation(value = "Update reservation details", notes = "Update the details of a reservation by reservation ID")

    public ResponseEntity<Reservation> updateReservationDetails(@PathVariable Long reservationId,
                                                                @RequestBody ReservationDetailsDTO reservationDetailsDTO) {
        Reservation updatedReservation = reservationService.updateReservationDetails(reservationId, reservationDetailsDTO);
        return ResponseEntity.ok(updatedReservation);
    }
*/
    
   

    // Endpoint pour récupérer toutes les réservations (pour les administrateurs)
    
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Get all reservations", notes = "Retrieve all reservations (for administrators)")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> allReservations = reservationService.getAllReservations();
        return ResponseEntity.ok(allReservations);
    }

    
    // Endpoint pour mettre à jour le statut d'une réservation (pour les administrateurs)
    @PutMapping("/{reservationId}/status")
    @ApiOperation(value = "Update reservation status", notes = "Update the status of a reservation by reservation ID (for administrators)")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateReservationStatus(@PathVariable Long reservationId,
                                                          @RequestParam RservationStatus status) {
        try {
            Reservation updatedReservation = reservationService.updateReservationStatus(reservationId, status);
            return ResponseEntity.ok("Mise à jour avec succès de la réservation avec l'ID : " + reservationId);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La réservation avec l'ID " + reservationId + " n'a pas été trouvée.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur est survenue lors de la mise à jour de la réservation avec l'ID : " + reservationId);
        }
    }

}
