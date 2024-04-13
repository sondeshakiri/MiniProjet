package com.codehotel.RoomRservation.model;

import java.io.Serializable;

public class RoomReservationId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Room room;
	private Reservation reservation;
	
    
    public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

    // Constructeur, getters et setters
    
    
}
