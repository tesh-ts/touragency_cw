package com.example.tourist_cw.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    private String name;

    private int star_rating;

    private String address;

    private String city;

    private String country;

    private String image_address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tour")
    public List<com.example.tourist_cw.entities.AdoptionRequest> adoptionRequests = new ArrayList<>();



}



