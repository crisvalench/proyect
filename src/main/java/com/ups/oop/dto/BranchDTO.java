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

public class BranchDTO {
    private String idBranch;
    private String registrationDate;
    private String nameBranch;
    private String city;
    private String address;
    private String phoneNumber;
    private String email;
}
