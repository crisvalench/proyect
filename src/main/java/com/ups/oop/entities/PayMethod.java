package com.ups.oop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String payMethod; //CASH, CREDIT CARD, TRANSFER, DEBIT CARD
    private String detail;
}
