package com.springapps.bookingapp.repositories;

import com.springapps.bookingapp.entities.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomReservationRepository extends JpaRepository<RoomReservation,Long> {
}
