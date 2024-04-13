package com.codehotel.RoomRservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehotel.RoomRservation.model.RoomReservation;
import com.codehotel.RoomRservation.model.RoomReservationId;

@Repository
public interface RoomReservationRepository extends JpaRepository<RoomReservation, RoomReservationId> {
    // Ajoutez des méthodes personnalisées si nécessaire
}
