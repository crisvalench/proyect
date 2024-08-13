package com.ups.oop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

//Sucursal
public class Branch extends BaseEntity{
    BaseEntity id;
    private String idBranch;
    private String nameBranch;
    BaseEntity address;
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = true)
    City idCity;
    BaseEntity phoneNumber;
    BaseEntity email;
}
