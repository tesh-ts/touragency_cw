package com.example.tourist_cw.services;

import com.example.tourist_cw.entities.Adopter;
import com.example.tourist_cw.repo.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AdopterService implements UserDetailsService {
    @Autowired
    UserRep userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Adopter adopter = userRepository.findByUsername(username);

        if (adopter == null)
            throw new UsernameNotFoundException("Пользователь не найден");

        return adopter;
    }
}
