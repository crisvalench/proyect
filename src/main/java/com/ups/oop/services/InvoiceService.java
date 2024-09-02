package com.ups.oop.services;

import com.ups.oop.dto.InvoiceDTO;
import com.ups.oop.entities.Invoice;
import com.ups.oop.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
            invoiceDTO.setInvoiceId(iv.getInvoiceId());
            invoiceDTO.setIssueDate(iv.getIssueDate());
            invoiceDTO.setBranch(iv.getBranch().getNameBranch());
            invoiceDTO.setClient(iv.getClient().getNameClient() + " " + iv.getClient().getLastNameClient());
            invoiceDTO.setAmountTotal(iv.getAmountTotal().toString());
            invoiceDTO.setSubTotal(String.valueOf(iv.getSubTotal()));
            invoiceDTO.setTotal(String.valueOf(iv.getTotal()));
            invoiceDTO.setSeller(iv.getSeller().getNameSeller() + " " + iv.getSeller().getLastNameSeller());
            invoiceDTO.setPayMethod(iv.getPayMethod().getPayMethodName());
            invoiceList.add(invoiceDTO);
        }
        return invoiceList;
    }
}
