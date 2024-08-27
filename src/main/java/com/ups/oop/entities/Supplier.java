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
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter

//Proveedor/ra
public class Supplier extends BaseEntity {

    private String idSupplier;
    private String rucSupplier;
    private String nameSupplier;

    @ManyToMany
    @JoinColumn(name = "city_id", nullable = true)
    private List<City> supplierCities;

    @OneToMany(mappedBy = "product")
    private List<Product> products = new ArrayList<>();

    public Supplier(){ super();}

    public Supplier(String idSupplier, String rucSupplier, String address, String phoneNumber, String email, Date registrationDate){
        super(registrationDate,address, phoneNumber, email);
        this.idSupplier = idSupplier;
        this.rucSupplier = rucSupplier;
    }
}
