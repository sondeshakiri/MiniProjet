package com.codehotel.RoomRservation.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.codehotel.RoomRservation.model.Room;

public interface RoomRepository extends JpaRepository<Room,Long> {

	List<Room> findByIdInAndCapacityGreaterThanEqual(List<Long> roomIds, int capacity);

	List<Room> findByCapacityGreaterThanEqual(int capacity);


	   @org.springframework.data.jpa.repository.Query("SELECT r FROM Room r")
	    List<Room> findCustomRooms();
}
