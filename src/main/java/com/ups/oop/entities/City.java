package com.ups.oop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    BaseEntity id;
    private String idCity;
    private String nameCity;

    @OneToMany(mappedBy = "branch")
    private List<Branch> branches = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    private List<Client> clients = new ArrayList<>();

    @OneToOne(mappedBy = "seller")
    private Seller seller;

    @ManyToMany(mappedBy = "supplier")
    private List<Supplier> suppliers = new ArrayList<>();


}
