package com.ups.oop.entities;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

//Vendedor
public class Seller extends BaseEntity{
    BaseEntity id;
    BaseEntity registrationDate;
    private String idSeller;
    private String ciSeller;
    private String nameSeller;
    private String lastNameSeller;
    BaseEntity address;
    City idCity;
    BaseEntity phoneNumber;
    BaseEntity email;
}
