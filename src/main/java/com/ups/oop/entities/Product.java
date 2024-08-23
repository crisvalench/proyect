package com.ups.oop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@Getter
@Setter

//Producto
public class Product extends BaseEntity{
    private String idProduct;
    private String nameProduct;
    private String detailProduct;
    private double price;
    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = true)
    Supplier idSupplier;

    public Product(){ super();}

    public Product(String idProduct, Date registrationDate, String nameProduct, String detailProduct, double price ) {
        super(registrationDate);
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.detailProduct = detailProduct;
        this.price = price;
    }
}
