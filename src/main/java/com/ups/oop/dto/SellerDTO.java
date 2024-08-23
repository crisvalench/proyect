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

public class SellerDTO {
    private String idSeller;
    private String registrationDate;
    private String ciSeller;
    private String nameSeller;
    private String lastNameSeller;
    private String city;
    private String address;
    private String phoneNumber;
    private String email;
}
