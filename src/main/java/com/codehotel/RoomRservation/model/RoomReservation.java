package com.codehotel.RoomRservation.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;



@Entity
@IdClass(RoomReservationId.class)
public class RoomReservation implements Serializable {
    // Ajoutez serialVersionUID si nécessaire
    private static final long serialVersionUID = 1L;
   
    @Id
    @ManyToOne
    private Room room;

    @Id
    @ManyToOne
    private Reservation reservation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    
    public RoomReservation(Room room, Reservation reservation, Date creationDate) {
		super();
		this.room = room;
		this.reservation = reservation;
		this.creationDate = creationDate;
	}

	public RoomReservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructeurs, getters, setters, etc.
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


    
    
}