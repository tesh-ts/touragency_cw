package com.example.tourist_cw.repo;

import com.example.tourist_cw.entities.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRep extends JpaRepository<Adopter, Integer> {
    Adopter findByUsername(String username);
}
