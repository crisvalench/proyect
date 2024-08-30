package com.ups.oop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

//Cliente
public class Client extends BaseEntity{
    private String idClient;
    private String ciClient;
    private String nameClient;
    private String lastNameClient;

    @ManyToOne
    @JoinColumn(name = "city", nullable = true)
     private City city;

    @OneToMany(mappedBy = "client_id")
    private List<Invoice> invoices = new ArrayList<>();

    public Client(){ super();}

    public Client(Long id, String idBranch, String nameBranch, String address, String phoneNumber, String email, Date registrationDate) {
        super(id,registrationDate, address, phoneNumber, email);
        this.idClient = idClient;
        this.ciClient = ciClient;
        this.nameClient = nameClient;
        this.lastNameClient = lastNameClient;
    }
}

