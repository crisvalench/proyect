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

//Producto
public class Product extends BaseEntity{
    BaseEntity id;
    BaseEntity registrationDate;
    private String idProduct;
    private String nameProduct;
    private String detailProduct;
    private double price;
    Supplier idSupplier;
}
