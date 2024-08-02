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

//Método de pago
public class PayMethod {
    private String idPayMethod;
    private String payMethod; //CASH, CREDIT CARD, TRANSFER, DEBIT CARD
    private String detail;
}
