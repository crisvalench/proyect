package com.ups.oop.services;

import com.ups.oop.dto.InvoiceDTO;
import com.ups.oop.entities.Invoice;
import com.ups.oop.repository.InvoiceRepository;

import java.util.ArrayList;
import java.util.List;

public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<InvoiceDTO> getInvoices(){
        Iterable<Invoice> invoiceIterable = invoiceRepository.findAll();

        List<InvoiceDTO> invoiceList = new ArrayList<>();
        for (Invoice iv : invoiceIterable){
            InvoiceDTO invoiceDTO = new InvoiceDTO();
            invoiceDTO.setIssueDate(iv.getIssueDate());
            invoiceDTO.setSupplier(iv.getSupplier().getNameSupplier());
            invoiceDTO.setClient(iv.getClient().getNameClient() + " " + iv.getClient().getLastNameClient());
            invoiceDTO.setSubtotal(iv.getSubtotal().toString());
            invoiceDTO.setTotal(iv.getTotal().toString());
            invoiceDTO.setSeller(iv.getSeller().getNameSeller() + " " + iv.getSeller().getLastNameSeller());
            invoiceDTO.setPayMethod(iv.getPayMethod().getPayMethodName());
            invoiceList.add(invoiceDTO);
        }
        return invoiceList;
    }
}
