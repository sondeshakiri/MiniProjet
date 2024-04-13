package com.codehotel.RoomRservation.DTO;

import java.util.List;

public class HotelDTO {
    private Long id;
    private int hotel_id;
    private String name;
    private String adresse;
    private String email;
    private String tel;
    private List<RoomDTO> rooms;

    public HotelDTO() {}

    public HotelDTO(int hotel_id, Long id, String name, String adresse, String email, String tel, List<RoomDTO> rooms) {
        this.id = id;
        this.hotel_id = hotel_id;
        this.name = name;
        this.adresse = adresse;
        this.email = email;
        this.tel = tel;
        this.rooms = rooms;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
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

    public List<RoomDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDTO> rooms) {
        this.rooms = rooms;
    }
}
