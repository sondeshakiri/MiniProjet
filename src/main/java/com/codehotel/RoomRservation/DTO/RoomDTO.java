package com.codehotel.RoomRservation.DTO;

import com.codehotel.RoomRservation.model.Hotel;
import com.codehotel.RoomRservation.model.RoomType;
import java.util.List;
import java.util.Set;

public class RoomDTO {
    private long id;
    private int numR;
    private int room_id;
    private double price;
    private int capacity;
    private RoomType type;
    private Set<String> amenities;
    private HotelDTO hotel;
    private List<PhotoDTO> photos;
    private List<DateRangeDTO> daterange;
    private Set<ReservationDTO> reservations;

    public RoomDTO() {}

    public RoomDTO(long id, int numR, int room_id, double price, int capacity, RoomType type, Set<String> amenities,
    		HotelDTO hotel, List<PhotoDTO> photos, List<DateRangeDTO> daterange, Set<ReservationDTO> reservations) {
        this.id = id;
        this.numR = numR;
        this.room_id = room_id;
        this.price = price;
        this.capacity = capacity;
        this.type = type;
        this.amenities = amenities;
        this.hotel = hotel;
        this.photos = photos;
        this.daterange = daterange;
        this.reservations = reservations;
    }

    // Getters and setters
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

    public HotelDTO getHotel() {
        return hotel;
    }

    public void setHotel(HotelDTO hotel) {
        this.hotel = hotel;
    }

    public List<PhotoDTO> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoDTO> photos) {
        this.photos = photos;
    }

    public List<DateRangeDTO> getDaterange() {
        return daterange;
    }

    public void setDaterange(List<DateRangeDTO> daterange) {
        this.daterange = daterange;
    }

    public Set<ReservationDTO> getReservations() {
        return reservations;
    }

    public void setReservations(Set<ReservationDTO> reservations) {
        this.reservations = reservations;
    }
}
