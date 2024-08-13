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
    @OneToOne
    @JoinColumn(name = "city_id", nullable = true)
    City idCity;
    BaseEntity phoneNumber;
    BaseEntity email;
}
