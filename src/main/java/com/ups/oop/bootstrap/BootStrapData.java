package com.ups.oop.bootstrap;

import com.ups.oop.repository.BranchRepository;
import com.ups.oop.repository.CityRepository;
import com.ups.oop.repository.ClientRepository;
import com.ups.oop.repository.PayMethodRepository;
import com.ups.oop.repository.ProductRepository;
import com.ups.oop.repository.SellerRepository;
import com.ups.oop.repository.SupplierRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CityRepository cityRepository;
    private final PayMethodRepository payMethodRepository;
    private final BranchRepository branchRepository;
    private final ClientRepository clientRepository;
    private final SellerRepository sellerRepository;
    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;

    public BootStrapData(CityRepository cityRepository, PayMethodRepository payMethodRepository, BranchRepository branchRepository, ClientRepository clientRepository, SellerRepository sellerRepository, SupplierRepository supplierRepository, ProductRepository productRepository) {
        this.cityRepository = cityRepository;
        this.payMethodRepository = payMethodRepository;
        this.branchRepository = branchRepository;
        this.clientRepository = clientRepository;
        this.sellerRepository = sellerRepository;
        this.supplierRepository = supplierRepository;
        this.productRepository = productRepository;
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
