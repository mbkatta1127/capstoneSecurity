package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.SecureUser;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.SecureUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {
    @Autowired
    private SecureUserRepository secureUserRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public SecureUser registerUser(String username, String password){
        if(secureUserRepository.findByUsername(username).isPresent()) return null;

        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);

        return secureUserRepository.save(new SecureUser(username,encodedPassword,username.split("@")[0],authorities));
    }
}
