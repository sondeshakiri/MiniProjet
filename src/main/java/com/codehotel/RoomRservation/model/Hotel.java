package com.codehotel.RoomRservation.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private int hotel_id;
	
	private String name;
	private String adresse;
	private String email;
	private String tel;
	

	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Room> rooms;
	
	
	
	
	
	
	
	public Hotel(int hotel_id, Long id, String name, String adresse, String email, String tel, List<Room> rooms) {
		super();
		this.id = id;
		this.hotel_id = hotel_id;
		this.name = name;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.rooms = rooms;
	}

	public Hotel()
	{
		
	}
	
	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	
}
