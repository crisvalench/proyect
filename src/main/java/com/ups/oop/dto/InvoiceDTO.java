package com.ups.oop.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InvoiceDTO {
    private String invoiceId;
    private String issueDate;
    private String supplier;
    private String client;
    private String amountTotal;
    private String subTotal;
    private String total;
    private String seller;
    private String payMethod;
}
