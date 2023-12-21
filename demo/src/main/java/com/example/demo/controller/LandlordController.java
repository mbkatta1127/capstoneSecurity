package com.example.demo.controller;

import com.example.demo.model.Landlord;
import com.example.demo.model.User;
import com.example.demo.service.LandlordService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//CORS because react runs on a different port so in order to request access the below line is required
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/landlord")
public class LandlordController {

    @Autowired
    private LandlordService landlordService;

    @PostMapping("/process_register")
    public Landlord processRegister(@RequestBody Landlord landlord) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String encodedPassword = passwordEncoder.encode(landlord.getPassword());
        landlord.setPassword(encodedPassword);

        return landlordService.createLandlord(landlord);
    }

    /*@GetMapping("/all")
    public List<Landlord> getyAllLandlords() {
        return landlordService.getAllLandlords();
    }*/



}
