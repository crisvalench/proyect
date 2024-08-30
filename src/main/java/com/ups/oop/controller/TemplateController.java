package com.ups.oop.controller;

import com.ups.oop.repository.BranchRepository;
import com.ups.oop.repository.CityRepository;
import com.ups.oop.repository.ClientRepository;
import com.ups.oop.repository.PayMethodRepository;
import com.ups.oop.repository.ProductRepository;
import com.ups.oop.repository.SellerRepository;
import com.ups.oop.repository.SupplierRepository;
import com.ups.oop.services.BranchService;
import com.ups.oop.services.CityService;
import com.ups.oop.services.ClientService;
import com.ups.oop.services.PayMethodService;
import com.ups.oop.services.ProductService;
import com.ups.oop.services.SellerService;
import com.ups.oop.services.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateController {
    private final CityService cityService;
    private final PayMethodService payMethodService;
    private final BranchService branchService;
    private final ClientService clientService;
    private final SellerService sellerService;
    private final SupplierService supplierService;
    private final ProductService productService;

    public TemplateController(CityService cityService, PayMethodService payMethodService, BranchService branchService, ClientService clientService, SellerService sellerService, SupplierService supplierService, ProductService productService) {
        this.cityService = cityService;
        this.payMethodService = payMethodService;
        this.branchService = branchService;
        this.clientService = clientService;
        this.sellerService = sellerService;
        this.supplierService = supplierService;
        this.productService = productService;
    }


    @GetMapping("/branches")
    public String getBranches(Model model){
        model.addAttribute("branches",  branchService.getBranches());
        return "branch/list";
    }

}
