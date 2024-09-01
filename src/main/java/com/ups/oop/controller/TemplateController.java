package com.ups.oop.controller;

import com.ups.oop.services.BranchService;
import com.ups.oop.services.CityService;
import com.ups.oop.services.ClientService;
import com.ups.oop.services.InvoiceDetailService;
import com.ups.oop.services.InvoiceService;
import com.ups.oop.services.PayMethodService;
import com.ups.oop.services.ProductService;
import com.ups.oop.services.SellerService;
import com.ups.oop.services.SupplierService;
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

    @GetMapping("/cities")
    public String getCities(Model model){
        model.addAttribute("cities",  cityService.getCities());
        return "city/list";
    }

    @GetMapping("/clients")
    public String getClients(Model model){
        model.addAttribute("clients",  clientService.getClients());
        return "client/list";
    }

    @GetMapping("/invoices-details")
    public String getInvoiceDetails(Model model){
        model.addAttribute("invoiceDetails",  invoiceDetailService.getInvoiceDetails());
        return "invoiceDetail/list";
    }

    @GetMapping("/invoices")
    public String getInvoice(Model model){
        model.addAttribute("invoice",  invoiceService.getInvoices());
        return "invoice/list";
    }

    @GetMapping("/pay-methods")
    public String getPayMethod(Model model){
        model.addAttribute("payMethod",  payMethodService.getPayMethods());
        return "payMethod/list";
    }

    @GetMapping("/products")
    public String getProducts(Model model){
        model.addAttribute("product",  productService.getProducts());
        return "product/list";
    }

    @GetMapping("/sellers")
    public String getSellers(Model model){
        model.addAttribute("seller",  sellerService.getSellers());
        return "seller/list";
    }

    @GetMapping("/suppliers")
    public String getSuppliers(Model model){
        model.addAttribute("supplier",  supplierService.getSuppliers());
        return "supplier/list";
    }
}
