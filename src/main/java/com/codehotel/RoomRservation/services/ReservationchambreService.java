package com.codehotel.RoomRservation.services;

import java.util.List;


import com.codehotel.RoomRservation.model.Room;
import com.codehotel.RoomRservation.model.RoomReservationRequest;

public interface ReservationchambreService {
	



	boolean reserveRoom(RoomReservationRequest request, Long userId);





	List<Room> searchAvailableRoomm(java.util.Date startDate, java.util.Date endDate, int capacity);


}
