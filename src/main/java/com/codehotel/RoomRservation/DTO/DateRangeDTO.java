package com.codehotel.RoomRservation.DTO;

import java.sql.Date;

public class DateRangeDTO {
    private int date_range_id;
    private Date startDate;
    private Date endDate;
    
    
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
