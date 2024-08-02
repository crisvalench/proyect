package com.ups.oop.entities;

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

//Cliente
public class Client extends BaseEntity{
    BaseEntity id;
    BaseEntity registrationDate;
    private String idClient;
    private String ciClient;
    private String nameClient;
    private String lastNameClient;
    BaseEntity address;
    City idCity;
    BaseEntity phoneNumber;
    BaseEntity email;
}
