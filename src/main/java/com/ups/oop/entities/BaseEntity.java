package com.ups.oop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected Date registrationDate;
    protected String address;
    protected String phoneNumber;
    protected String email;

    public BaseEntity(Long id,Date registrationDate, String address, String phoneNumber, String email) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public BaseEntity(Long id,Date registrationDate) {
        this.id = id;
        this.registrationDate = registrationDate;
    }
}
