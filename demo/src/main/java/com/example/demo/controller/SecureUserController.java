package com.example.demo.controller;

import com.example.demo.model.SecureUser;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.SecureUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secureUser")
@CrossOrigin(origins = "http://localhost:3000")
public class SecureUserController {

    @Autowired
    private SecureUserService secureUserService;

    @PostMapping("/signIn")
    public String helloUserController(){

        return "User access level";
    }

}
