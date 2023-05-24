package com.example.tourist_cw.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "adoption_request")
@Getter
@Setter
public class AdoptionRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user", nullable = false)
    private com.example.tourist_cw.entities.Adopter adopter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_tour", nullable = false)
    private Tour tour;

}
