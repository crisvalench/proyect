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
    @JoinColumn(name = "city", nullable = true)
    private City city;

    public Branch(){ super();}

    public Branch(Long id,String idBranch, String nameBranch, String address, String phoneNumber, String email, Date registrationDate){
        super(id,registrationDate,address, phoneNumber, email);
        this.idBranch = idBranch;
        this.nameBranch = nameBranch;
    }
}
