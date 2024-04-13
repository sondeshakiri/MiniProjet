package com.codehotel.RoomRservation.model;

import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(unique = true)
    private int numR;
    private int room_id;
    private double price;
    private int capacity;
    @Enumerated(EnumType.STRING)
    private RoomType type;
    
    
    @ElementCollection
    private Set<String> amenities;
    
	@ManyToOne

    private Hotel hotel;
	

	

	@OneToMany(mappedBy="room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> photos;
    
   
	@OneToMany(mappedBy="room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DateRange> daterange;
	
	
	
	 @OneToMany(mappedBy = "room")
	 private Set<RoomReservation> reservations;
	 
	 
	 
	 
	 public Hotel getHotel() {
			return hotel;
		}


		public void setHotel(Hotel hotel) {
			this.hotel = hotel;
		}


	public Room(long id, int numR, int room_id, double price, int capacity, RoomType type, Set<String> amenities,
			Hotel hotel_id, List<Photo> photos, List<DateRange> daterange, Set<RoomReservation> reservations) {
		super();
		this.id = id;
		this.numR = numR;
		this.room_id = room_id;
		this.price = price;
		this.capacity = capacity;
		this.type = type;
		this.amenities = amenities;
		this.hotel = hotel_id;
		this.photos = photos;
		this.daterange = daterange;
		this.reservations = reservations;
	}


	public Room() {
		
		
	}

	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public int getNumR() {
		return numR;
	}



	public void setNumR(int numR) {
		this.numR = numR;
	}



	public int getRoom_id() {
		return room_id;
	}



	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getCapacity() {
		return capacity;
	}



	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}



	public RoomType getType() {
		return type;
	}



	public void setType(RoomType type) {
		this.type = type;
	}



	public Set<String> getAmenities() {
		return amenities;
	}



	public void setAmenities(Set<String> amenities) {
		this.amenities = amenities;
	}



	public Hotel getHotel_id() {
		return hotel;
	}



	public void setHotel_id(Hotel hotel_id) {
		this.hotel = hotel_id;
	}



	public List<Photo> getPhotos() {
		return photos;
	}



	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}



	public List<DateRange> getDaterange() {
		return daterange;
	}



	public void setDaterange(List<DateRange> daterange) {
		this.daterange = daterange;
	}



	public Set<RoomReservation> getReservations() {
		return reservations;
	}



	public void setReservations(Set<RoomReservation> reservations) {
		this.reservations = reservations;
	}



	
	
    




}

