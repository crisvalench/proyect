package com.ups.oop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JoinColumn(name = "city_id", nullable = true)
    private List<City> supplierCities;

    @OneToMany(mappedBy = "product")
    private List<Product> products = new ArrayList<>();
            
    BaseEntity phoneNumber;
    BaseEntity email;

}
