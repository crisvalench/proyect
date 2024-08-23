package com.ups.oop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@Getter
@Setter

//Cliente
public class Client extends BaseEntity{
    private String idClient;
    private String ciClient;
    private String nameClient;
    private String lastNameClient;
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = true)
    City idCity;

    public Client(){ super();}

    public Client(String idBranch, String nameBranch, String address, String phoneNumber, String email, Date registrationDate) {
        super(registrationDate, address, phoneNumber, email);
        this.idClient = idClient;
        this.ciClient = ciClient;
        this.nameClient = nameClient;
        this.lastNameClient = lastNameClient;
    }
}

