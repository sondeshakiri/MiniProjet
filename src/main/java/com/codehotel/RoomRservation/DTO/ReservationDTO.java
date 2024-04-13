package com.codehotel.RoomRservation.DTO;

import com.codehotel.RoomRservation.model.RservationStatus;

import java.util.Set;

public class ReservationDTO {
    private int id;
    private int idReservation;
    private RservationStatus rservationStatus;
    private UserDTO user;
    private Set<RoomDTO> rooms;

    public ReservationDTO() {}

    public ReservationDTO(int id, int idReservation, RservationStatus rservationStatus, UserDTO user, Set<RoomDTO> rooms) {
        this.id = id;
        this.idReservation = idReservation;
        this.rservationStatus = rservationStatus;
        this.user = user;
        this.rooms = rooms;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public RservationStatus getRservationStatus() {
        return rservationStatus;
    }

    public void setRservationStatus(RservationStatus rservationStatus) {
        this.rservationStatus = rservationStatus;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Set<RoomDTO> getRooms() {
        return rooms;
    }

    public void setRooms(Set<RoomDTO> rooms) {
        this.rooms = rooms;
    }
}
