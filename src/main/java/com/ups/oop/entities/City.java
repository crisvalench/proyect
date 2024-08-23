package com.ups.oop.entities;

import jakarta.persistence.*;
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

//Ciudad
public class City extends BaseEntity {
    private String idCity;
    private String nameCity;

    @OneToMany(mappedBy = "branch")
    private List<Branch> branches = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    private List<Client> clients = new ArrayList<>();

    @OneToOne(mappedBy = "seller")
    private Seller seller;

    @ManyToMany
    @JoinTable(
            name = "city_supplier",
            joinColumns = @JoinColumn(name = "city_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    private List<Supplier> suppliers = new ArrayList<>();

}
