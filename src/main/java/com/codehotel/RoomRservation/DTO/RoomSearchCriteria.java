package com.codehotel.RoomRservation.DTO;

import com.codehotel.RoomRservation.model.DateRange;
import com.codehotel.RoomRservation.model.RoomType;

import java.util.Set;

public class RoomSearchCriteria {
	
    private DateRange daterange;

    public DateRange getDaterange() {
		return daterange;
	}

	public void setDaterange(DateRange daterange) {
		this.daterange = daterange;
	}

	private int capacity;
	
    private Set<String> amenities;

    public RoomSearchCriteria() {
    }

    public RoomSearchCriteria(DateRange dateRange, int capacity, Set<String> amenities) {
        this.daterange = dateRange;
        this.capacity = capacity;

    }




  

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

 
}
