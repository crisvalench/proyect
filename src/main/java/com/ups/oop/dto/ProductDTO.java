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

public class ProductDTO {
    private String idProduct;
    private String nameProduct;
    private String supplier;
    private String detailProduct;
    private String price;
}
