package com.codehotel.RoomRservation.model;


public class RoomReservationRequest {
    private Long roomId;
    private DateRange dateRange;
   

    public DateRange getDateRange() {
		return dateRange;
	}

	public void setDateRange(DateRange dateRange) {
		this.dateRange = dateRange;
	}

	public RoomReservationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomReservationRequest(Long roomId, DateRange date) {
		super();
		this.roomId = roomId;
		this.dateRange = date;
	}

	
	public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

   
}
