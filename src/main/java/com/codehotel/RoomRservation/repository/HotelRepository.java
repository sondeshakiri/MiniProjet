package com.codehotel.RoomRservation.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehotel.RoomRservation.DTO.HotelDTO;
import com.codehotel.RoomRservation.model.*;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {
	Optional<Hotel> findById(Long id);
	HotelDTO findByName(String name);


}
