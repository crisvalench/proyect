package com.ups.oop.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CityDTO {
    private String cityId;
    private String registrationDate;
    private String nameCity;
//    private List<String> clients;
//    private List<String> branches;
//    private String seller;
//    private List<String> suppliers;
}
