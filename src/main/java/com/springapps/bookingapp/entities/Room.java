package com.springapps.bookingapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //O camera are numar, pret pe noapte, numar de persoane care pot fi cazate si o lista de rezervari
    private Long roomNumber;
    private Double pricePerNight;
    private Integer guestNumber;

    @OneToMany(mappedBy = "room",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JsonManagedReference("room-roomreservation")
    List<RoomReservation> roomReservations;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonBackReference("hotel-room")
    private Hotel hotel;


    public Room() {}

    public Room(Long roomNumber, Double pricePerNight, Integer guestNumber, Hotel hotel) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.guestNumber = guestNumber;
        this.hotel = hotel;
        roomReservations = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Integer getGuestNumber() {
        return guestNumber;
    }

    public void setGuestNumber(Integer guestNumber) {
        this.guestNumber = guestNumber;
    }

    public List<RoomReservation> getRoomReservations() {
        return roomReservations;
    }

    public void setRoomReservations(List<RoomReservation> roomReservations) {
        this.roomReservations = roomReservations;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
