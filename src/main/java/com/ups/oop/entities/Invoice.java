package com.ups.oop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String invoiceId;
    private String issueDate;
    private Integer subtotal;
    private Integer total;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = true)
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = true)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "pay_id", nullable = true)
    private PayMethod payMethod;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = true)
    private Seller seller;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceDetail> invoiceDetails = new ArrayList<>();

}
