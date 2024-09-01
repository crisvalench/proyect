package com.ups.oop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Supplier supplier;

    @OneToMany(mappedBy = "product")
    private List<InvoiceDetail> invoiceDetails = new ArrayList<>();

    public Product(){ super();}

    public Product(Long id,String idProduct, Date registrationDate, String nameProduct, String detailProduct, double price ) {
        super(id,registrationDate);
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.detailProduct = detailProduct;
        this.price = price;
    }
}
