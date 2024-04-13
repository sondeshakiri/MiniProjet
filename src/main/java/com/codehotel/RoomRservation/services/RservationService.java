package com.codehotel.RoomRservation.services;

import java.util.List;

import com.codehotel.RoomRservation.model.Reservation;
import com.codehotel.RoomRservation.model.RservationStatus;

public interface RservationService {

	List<Reservation> getUserReservations(Long userId);

	List<Reservation> getAllReservations();

	Reservation updateReservationStatus(Long reservationId, RservationStatus status);

}
