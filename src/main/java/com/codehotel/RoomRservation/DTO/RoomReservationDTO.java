package com.codehotel.RoomRservation.DTO;

import java.util.Date;

public class RoomReservationDTO {
    private Long roomId;
    private Long reservationId;
    private Date creationDate;

    // Constructeurs
    
    
    public RoomReservationDTO(Long roomId, Long reservationId, Date creationDate) {
        this.roomId = roomId;
        this.reservationId = reservationId;
        this.creationDate = creationDate;
    }

    public RoomReservationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Getters  setters
    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}

