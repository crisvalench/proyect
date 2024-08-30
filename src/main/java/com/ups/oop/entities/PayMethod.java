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

//Método de pago
public class PayMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String idPayMethod;
    private String payMethodName; //CASH, CREDIT CARD, TRANSFER, DEBIT CARD
    private String detail;

    @OneToMany(mappedBy = "payMethod")
    private List<Invoice> invoices = new ArrayList<>();
}
