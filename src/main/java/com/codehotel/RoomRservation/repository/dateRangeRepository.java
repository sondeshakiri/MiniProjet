package com.codehotel.RoomRservation.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codehotel.RoomRservation.model.DateRange;

public interface dateRangeRepository  extends JpaRepository<DateRange,Integer> {

	List<DateRange> findByRoomId(Long roomId);

    List<DateRange> findByRoomIdAndStartDateAndEndDate(Long roomId, Date startDate, Date endDate);

	List<DateRange> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(Date startDate, Date endDate);
	

}
