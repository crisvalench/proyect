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

public class SupplierDTO {
    private String idSupplier;
    private String rucSupplier;
    private String nameSupplier;
    private String city;
    private String address;
    private String phoneNumber;
    private String email;
   // private List<String> products;
}
