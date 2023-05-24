package com.example.tourist_cw.repo;

import com.example.tourist_cw.entities.AdoptionRequest;
import com.example.tourist_cw.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ARequestRep extends JpaRepository<AdoptionRequest, Integer> {
    AdoptionRequest findByAdopter(String adopter);

    AdoptionRequest findByTour(Tour tour);

}
