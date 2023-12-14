package com.springapps.bookingapp.service;

import com.springapps.bookingapp.repositories.ReservationRepository;
import com.springapps.bookingapp.repositories.RoomRepository;
import com.springapps.bookingapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;

    private UserRepository userRepository;
    private RoomRepository roomRepository;
    private RoomService roomService;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository, RoomRepository roomRepository, RoomService roomService) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.roomService = roomService;
    }




}
