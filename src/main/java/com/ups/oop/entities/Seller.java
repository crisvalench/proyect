package com.ups.oop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

//Vendedor
public class Seller extends BaseEntity{
    private String idSeller;
    private String ciSeller;
    private String nameSeller;
    private String lastNameSeller;

    @ManyToOne
    @JoinColumn(name = "city")
    private City city;

    @OneToMany(mappedBy = "seller")
    private List<Invoice> invoices = new ArrayList<>();

    public Seller(){ super();}

    public Seller(Long id,String idSeller, String ciSeller, String nameSeller, String lastNameSeller,String address, String phoneNumber, String email, Date registrationDate){
        super(id,registrationDate,address, phoneNumber, email);
        this.idSeller = idSeller;
        this.ciSeller = ciSeller;
        this.nameSeller = nameSeller;
        this.lastNameSeller = lastNameSeller;
    }
}
