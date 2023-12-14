package com.springapps.bookingapp.service;

import com.springapps.bookingapp.repositories.HotelRepository;
import com.springapps.bookingapp.repositories.RoleRepository;
import com.springapps.bookingapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;
    RoleRepository roleRepository;
    HotelRepository hotelRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, HotelRepository hotelRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.hotelRepository = hotelRepository;
    }


}
