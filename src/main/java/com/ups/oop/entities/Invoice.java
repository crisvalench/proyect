package com.ups.oop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private Integer amountTotal;
    private double subTotal;
    private double total;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = true)
    private Branch branch;

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
