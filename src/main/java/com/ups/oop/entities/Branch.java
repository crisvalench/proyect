package com.ups.oop.entities;

import jakarta.persistence.Entity;
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
    City idCity;
    BaseEntity phoneNumber;
    BaseEntity email;
}
