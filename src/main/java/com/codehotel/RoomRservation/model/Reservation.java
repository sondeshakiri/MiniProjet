package com.codehotel.RoomRservation.model;



import java.sql.Date;
import java.util.Set;


import javax.persistence.*;


@Entity

public class Reservation {
	

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private int idReservation;
	@Enumerated(EnumType.STRING)    
	private RservationStatus RservationStatus;
	
	@ManyToOne
	@JoinColumn(name = "iduser")
	private User user; 
	
	@OneToMany(mappedBy = "reservation")
    private Set<RoomReservation> rooms ;

	
	private Date startDate;
	private Date endDate;

public Reservation() {
	super();
	// TODO Auto-generated constructor stub
}


public Reservation(Long id, int idReservation, com.codehotel.RoomRservation.model.RservationStatus rservationStatus,
		User user, Set<RoomReservation> rooms, Date dateStart, Date dateEnd) {
	super();
	this.id = id;
	this.idReservation = idReservation;
	RservationStatus = rservationStatus;
	this.user = user;
	this.rooms = rooms;
	this.startDate = dateStart;
	this.endDate = dateEnd;
}


public Date getDateStart() {
	return startDate;
}
public void setDateStart(Date dateStart) {
	this.startDate = dateStart;
}
public Date getDateEnd() {
	return endDate;
}
public void setDateEnd(Date dateEnd) {
	this.endDate = dateEnd;
}


	 
	 
	 


	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<RoomReservation> getRooms() {
		return rooms;
	}
	public void setRooms(Set<RoomReservation> rooms) {
		this.rooms = rooms;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public RservationStatus getRservationStatus() {
		return RservationStatus;
	}
	public void setRservationStatus(RservationStatus rservationStatus) {
		RservationStatus = rservationStatus;
	}
	public int getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
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
