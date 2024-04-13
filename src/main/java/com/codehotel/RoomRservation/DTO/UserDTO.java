package com.codehotel.RoomRservation.DTO;

import java.util.List;

public class UserDTO {
    private long id;
    private int idUser;
    private String name;
    private String surName;
    private String tel;
    private String email;
    private String password;
    private String role;
    private List<ReservationDTO> reservation;

    public UserDTO() {}

    public UserDTO(long id, int idUser, String name, String surName, String tel, String email, String password, String role, List<ReservationDTO> reservation) {
        this.id = id;
        this.idUser = idUser;
        this.name = name;
        this.surName = surName;
        this.tel = tel;
        this.email = email;
        this.password = password;
        this.role = role;
        this.reservation = reservation;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<ReservationDTO> getReservation() {
        return reservation;
    }

    public void setReservation(List<ReservationDTO> reservation) {
        this.reservation = reservation;
    }
}
