package com.example.demo.controller;

import com.example.demo.model.SecureUser;
import com.example.demo.repository.SecureUserRepository;
import com.example.demo.service.SecureUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/landlord")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    @Autowired
    private SecureUserService secureUserService;

    @Autowired
    private SecureUserRepository secureUserRepository;

    @PostMapping("/")
    public String helloAdminController(){
        return "Admin level access";
    }

    @GetMapping("/test")
    public String test(){
        return "Are you an admin?";
    }

    @GetMapping("/all")
    public List<SecureUser> getAllLandlord() {
        return secureUserService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SecureUser> getLandlordById(@PathVariable Integer id) {
        SecureUser landlord = secureUserService.getUserById(id);
        if (landlord != null) {
            return ResponseEntity.ok(landlord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*@PostMapping
    public ResponseEntity<Landlord> createLandlord(@RequestBody Landlord landlord) {
        Landlord createdLandlord = landlordService.createLandlord(landlord);
        return ResponseEntity.ok(createdLandlord);
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<SecureUser> updateLandlord(@PathVariable Integer id, @RequestBody SecureUser landlordDetails) {
        SecureUser updatedLandlord = secureUserService.updateUser(id, landlordDetails);
        if (updatedLandlord != null) {
            return ResponseEntity.ok(updatedLandlord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLandlord(@PathVariable Integer id) {
        landlordService.deleteLandlord(id);
        return ResponseEntity.noContent().build();
    }*/
}
