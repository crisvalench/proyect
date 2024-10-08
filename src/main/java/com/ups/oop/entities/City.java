package com.ups.oop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter

//Ciudad
public class City extends BaseEntity {
    private String cityId;
    private String nameCity;

    @OneToMany(mappedBy = "city") //branches
    private List<Branch> branches = new ArrayList<>();

    @OneToMany(mappedBy = "city")
    private List<Client> clients = new ArrayList<>();

    @OneToMany(mappedBy = "city")
    private List<Seller> sellers = new ArrayList<>();

    @OneToMany(mappedBy = "city")
    private List<Supplier> suppliers = new ArrayList<>();


    public City(){ super();}


    public City(Long id, Date registrationDate, String cityId, String nameCity) {
        super(id,registrationDate);
        this.cityId = cityId;
        this.nameCity = nameCity;
    }
}
