package com.ups.oop.controller;

import com.ups.oop.repository.BranchRepository;
import com.ups.oop.repository.CityRepository;
import com.ups.oop.repository.ClientRepository;
import com.ups.oop.repository.PayMethodRepository;
import com.ups.oop.repository.ProductRepository;
import com.ups.oop.repository.SellerRepository;
import com.ups.oop.repository.SupplierRepository;
import com.ups.oop.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TemplateController {
    private final CityService cityService;
    private final PayMethodService payMethodService;
    private final BranchService branchService;
    private final ClientService clientService;
    private final SellerService sellerService;
    private final SupplierService supplierService;
    private final ProductService productService;
    private final InvoiceDetailService invoiceDetailService;
    private final InvoiceService invoiceService;

    public TemplateController(CityService cityService, PayMethodService payMethodService, BranchService branchService, ClientService clientService, SellerService sellerService, SupplierService supplierService, ProductService productService, InvoiceDetailService invoiceDetailService, InvoiceService invoiceService) {
        this.cityService = cityService;
        this.payMethodService = payMethodService;
        this.branchService = branchService;
        this.clientService = clientService;
        this.sellerService = sellerService;
        this.supplierService = supplierService;
        this.productService = productService;
        this.invoiceDetailService = invoiceDetailService;
        this.invoiceService = invoiceService;
    }


    @GetMapping("/branches")
    public String getBranches(Model model){
        model.addAttribute("branches",  branchService.getBranches());
        return "branch/list";
    }

    @GetMapping("/invoices-details")
    public String getInvoiceDetails(Model model){
        model.addAttribute("invoiceDetails",  invoiceDetailService.getInvoiceDetails());
        return "invoice-details/list";
    }

}
