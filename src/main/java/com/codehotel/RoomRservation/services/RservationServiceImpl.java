package com.codehotel.RoomRservation.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.codehotel.RoomRservation.model.*;
import com.codehotel.RoomRservation.repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RservationServiceImpl implements RservationService {
	 @Autowired
	    private ReservationRepository reservationRepository;

	 
	// Constructor injection
	    public RservationServiceImpl(ReservationRepository reservationRepository) {
	        this.reservationRepository = reservationRepository;
	    }
	    
	
	@Override
	public List<Reservation> getUserReservations(Long userId) {
        return reservationRepository.findByUserId(userId);

	}

	@Override
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	
	}

	@Override
	 public Reservation updateReservationStatus(Long reservationId, RservationStatus status) {
	        // Retrieve the reservation from the repository
	        Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
	        
	        if (optionalReservation.isPresent()) {
	            Reservation reservation = optionalReservation.get();
	            // Update the status
	            reservation.setRservationStatus(status);
	            // Save the updated reservation
	            return reservationRepository.save(reservation);
	        } else {
	            // If reservation not found, throw an exception or return null/empty value
	            throw new NoSuchElementException("Reservation not found with ID: " + reservationId);
	        }
	    }

}
