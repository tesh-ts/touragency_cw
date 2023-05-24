package com.example.tourist_cw.repo;

import com.example.tourist_cw.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TourRep extends JpaRepository<Tour, Integer> {
    Tour findByName(String name);

    Tour findById(int id);


}