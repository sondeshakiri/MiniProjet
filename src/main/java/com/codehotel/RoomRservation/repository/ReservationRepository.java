package com.codehotel.RoomRservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codehotel.RoomRservation.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

	List<Reservation> findByUserId(Long userId);

}
