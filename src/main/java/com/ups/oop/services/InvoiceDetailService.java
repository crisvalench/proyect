package com.ups.oop.services;

import com.ups.oop.dto.InvoiceDetailsDTO;
import com.ups.oop.entities.InvoiceDetail;
import com.ups.oop.repository.InvoiceDetailRepository;

import java.util.ArrayList;
import java.util.List;

public class InvoiceDetailService {

    private final InvoiceDetailRepository invoiceDetailRepository;

    public InvoiceDetailService(InvoiceDetailRepository invoiceDetailRepository) {
        this.invoiceDetailRepository = invoiceDetailRepository;
    }


    public List<InvoiceDetailsDTO> getInvoiceDetails(){
        Iterable<InvoiceDetail> invoiceDetailIterable = invoiceDetailRepository.findAll();
        List<InvoiceDetailsDTO> invoiceDetailsList = new ArrayList<>();

        for(InvoiceDetail id : invoiceDetailIterable){
            InvoiceDetailsDTO invoiceDetailsDTO = new InvoiceDetailsDTO();
            invoiceDetailsDTO.setInvoiceId(id.getInvoice().getInvoiceId());
            invoiceDetailsDTO.setProduct(id.getProduct().getNameProduct());
            invoiceDetailsDTO.setAmount(id.getAmount());
            invoiceDetailsDTO.setSubtotal(id.getSubtotal());
            invoiceDetailsDTO.setIva(id.getIva());
            invoiceDetailsDTO.setTotal(id.getTotal());

            invoiceDetailsList.add(invoiceDetailsDTO);
        }
        return invoiceDetailsList;
    }
}
