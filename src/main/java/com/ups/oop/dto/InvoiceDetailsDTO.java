package com.ups.oop.dto;

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
public class InvoiceDetailsDTO {
    private String invoiceDetailId;
    private String invoiceId;
    private String product;
    private String amount;
    private String subtotal;
    private String iva;
    private String total;
}
