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

//Proveedor/ra
public class Supplier extends BaseEntity {
    BaseEntity id;
    BaseEntity registrationDate;
    private String idSupplier;
    private int rucSupplier;
    BaseEntity address;
    City idCity;
    BaseEntity phoneNumber;
    BaseEntity email;

}
