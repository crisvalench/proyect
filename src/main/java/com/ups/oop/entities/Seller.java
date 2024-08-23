package com.ups.oop.entities;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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

    @OneToOne
    @JoinColumn(name = "city_id", nullable = true)
    City idCity;

    public Seller(){ super();}

    public Seller(String idSeller, String ciSeller, String nameSeller, String lastNameSeller,String address, String phoneNumber, String email, Date registrationDate){
        super(registrationDate,address, phoneNumber, email);
        this.idSeller = idSeller;
        this.ciSeller = ciSeller;
        this.nameSeller = nameSeller;
        this.lastNameSeller = lastNameSeller;
    }
}
