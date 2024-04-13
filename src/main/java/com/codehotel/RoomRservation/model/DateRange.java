package com.codehotel.RoomRservation.model;

import java.sql.Date;


import javax.persistence.*;

@Entity
public class DateRange {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int date_range_id;
	private Date startDate;
	private Date endDate;
    
	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;


	

	
	public DateRange(Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public DateRange(int date_range_id, Date startDate, Date endDate, Room room) {
		super();
		this.date_range_id = date_range_id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.room = room;
	}
	public DateRange() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public int getDate_range_id() {
		return date_range_id;
	}
	public void setDate_range_id(int date_range_id) {
		this.date_range_id = date_range_id;
	}

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
