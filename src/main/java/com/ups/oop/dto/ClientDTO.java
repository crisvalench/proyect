package com.ups.oop.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ClientDTO {
    private String idClient;
    private String registrationDate;
    private String ciClient;
    private String nameClient;
    private String lastNameClient;
    private String city;
    private String address;
    private String phoneNumber;
    private String email;
}
