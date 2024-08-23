package com.ups.oop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter

//Sucursal
public class Branch extends BaseEntity{
    private String idBranch;
    private String nameBranch;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = true)
    City idCity;

    public Branch(){ super();}

    public Branch(String idBranch, String nameBranch, String address, String phoneNumber, String email, Date registrationDate){
        super(registrationDate,address, phoneNumber, email);
        this.idBranch = idBranch;
        this.nameBranch = nameBranch;
    }
}
