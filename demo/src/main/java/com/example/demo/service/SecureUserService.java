package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.SecureUser;
import com.example.demo.model.User;
import com.example.demo.repository.SecureUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SecureUserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private SecureUserRepository secureUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the user details service");

        return secureUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Invalid User"));

        /*if(!username.equals("ethan@fiserv.com")) throw new UsernameNotFoundException("not Ethan");
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1, "USER"));

        return new SecureUser(1,"ethan@fiserv.com",encoder.encode("password"),"name",roles);*/
    }

}
