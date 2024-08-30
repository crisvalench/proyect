package com.ups.oop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String invoiceDetailId;
    private String amount;
    private String subtotal;
    private String iva;
    private String total;

    @ManyToOne
    @JoinColumn(name = "invoice_detail_id", nullable = true)
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = true)
    private Product product;

}
