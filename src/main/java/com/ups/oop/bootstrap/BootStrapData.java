package com.ups.oop.bootstrap;

import com.ups.oop.entities.Branch;
import com.ups.oop.entities.City;
import com.ups.oop.entities.Client;
import com.ups.oop.entities.Invoice;
import com.ups.oop.entities.InvoiceDetail;
import com.ups.oop.entities.PayMethod;
import com.ups.oop.entities.Product;
import com.ups.oop.entities.Seller;
import com.ups.oop.entities.Supplier;
import com.ups.oop.repository.BranchRepository;
import com.ups.oop.repository.CityRepository;
import com.ups.oop.repository.ClientRepository;
import com.ups.oop.repository.InvoiceDetailRepository;
import com.ups.oop.repository.InvoiceRepository;
import com.ups.oop.repository.PayMethodRepository;
import com.ups.oop.repository.ProductRepository;
import com.ups.oop.repository.SellerRepository;
import com.ups.oop.repository.SupplierRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CityRepository cityRepository;
    private final PayMethodRepository payMethodRepository;
    private final BranchRepository branchRepository;
    private final ClientRepository clientRepository;
    private final SellerRepository sellerRepository;
    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceDetailRepository invoiceDetailRepository;

    public BootStrapData(CityRepository cityRepository, PayMethodRepository payMethodRepository, BranchRepository branchRepository, ClientRepository clientRepository, SellerRepository sellerRepository, SupplierRepository supplierRepository, ProductRepository productRepository, InvoiceRepository invoiceRepository, InvoiceDetailRepository invoiceDetailRepository) {
        this.cityRepository = cityRepository;
        this.payMethodRepository = payMethodRepository;
        this.branchRepository = branchRepository;
        this.clientRepository = clientRepository;
        this.sellerRepository = sellerRepository;
        this.supplierRepository = supplierRepository;
        this.productRepository = productRepository;
        this.invoiceRepository = invoiceRepository;
        this.invoiceDetailRepository = invoiceDetailRepository;
    }


    @Override
    public void run(String... args) throws Exception {

   //createPayMethod
        PayMethod payMethod1 = new PayMethod();
        payMethod1.setIdPayMethod("PM001");
        payMethod1.setPayMethodName("Cash");
        payMethod1.setDetail("Cash payment");

        PayMethod payMethod2 = new PayMethod();
        payMethod2.setIdPayMethod("PM002");
        payMethod2.setPayMethodName("Credit Card");
        payMethod2.setDetail("Payment by credit card");

        PayMethod payMethod3 = new PayMethod();
        payMethod3.setIdPayMethod("PM003");
        payMethod3.setPayMethodName("Transfer");
        payMethod3.setDetail("Payment by bank transfer");

        PayMethod payMethod4 = new PayMethod();
        payMethod4.setIdPayMethod("PM004");
        payMethod4.setPayMethodName("Debit Card");
        payMethod4.setDetail("Payment by debit card");

        payMethodRepository.save(payMethod1);
        payMethodRepository.save(payMethod2);
        payMethodRepository.save(payMethod3);
        payMethodRepository.save(payMethod4);


        //City1
        City city1 = new City();
        city1.setCityId("C01");
        city1.setRegistrationDate(new Date());
        city1.setNameCity("Quito");
        cityRepository.save(city1);

        //Branch1
        Branch branch1 = new Branch();
        branch1.setIdBranch("B001");
        branch1.setRegistrationDate(new Date());
        branch1.setNameBranch("Sucursal Quito Centro");
        branch1.setAddress("Av. Amazonas 123");
        branch1.setPhoneNumber("0991234567");
        branch1.setEmail("quito@branch.com");
        branchRepository.save(branch1);

        branch1.setCity(city1);
        city1.getBranches().add(branch1);
        branchRepository.save(branch1);

        //City2
        City city2 = new City();
        city2.setCityId("C02");
        city2.setRegistrationDate(new Date());
        city2.setNameCity("Guayaquil");
        cityRepository.save(city2);

        //Branch2
        Branch branch2 = new Branch();
        branch2.setIdBranch("B002");
        branch2.setRegistrationDate(new Date());
        branch2.setNameBranch("Sucursal Guayaquil Norte");
        branch2.setAddress("Calle 9 de Octubre 456");
        branch2.setPhoneNumber("0992345678");
        branch2.setEmail("guayaquil@branch.com");
        branchRepository.save(branch2);

        branch2.setCity(city2);
        city2.getBranches().add(branch2);
        branchRepository.save(branch2);

        //City3
        City city3 = new City();
        city3.setCityId("C03");
        city3.setRegistrationDate(new Date());
        city3.setNameCity("Cuenca");
        cityRepository.save(city3);

        //Branch3
        Branch branch3 = new Branch();
        branch3.setIdBranch("B003");
        branch3.setNameBranch("Sucursal Cuenca Sur");
        branch3.setAddress("Av. de las Américas 789");
        branch3.setPhoneNumber("0993456789");
        branch3.setEmail("cuenca@branch.com");
        branch3.setRegistrationDate(new Date());
        branchRepository.save(branch3);

        branch3.setCity((city3));
        city3.getBranches().add(branch3);
        branchRepository.save(branch3);

        //City4
        City city4 = new City();
        city4.setCityId("C04");
        city4.setRegistrationDate(new Date());
        city4.setNameCity("Manta");
        cityRepository.save(city4);

        //Branch
        Branch branch4 = new Branch();
        branch4.setIdBranch("B004");
        branch4.setNameBranch("Sucursal Manta Oeste");
        branch4.setAddress("Calle 7 de Agosto 321");
        branch4.setPhoneNumber("0994567890");
        branch4.setEmail("manta@branch.com");
        branch4.setRegistrationDate(new Date());
        branchRepository.save(branch4);

        branch4.setCity((city4));
        city4.getBranches().add(branch4);
        branchRepository.save(branch4);

    //City5
        City city5 = new City();
        city5.setCityId("C05");
        city5.setRegistrationDate(new Date());
        city5.setNameCity("Machala");

        cityRepository.save(city5);

    //Client 1
        Client client1 = new Client();
        client1.setIdClient("C001");
        client1.setRegistrationDate(new Date());
        client1.setCiClient("123456789");
        client1.setNameClient("John");
        client1.setLastNameClient("Doe");
        client1.setCity(city1);
        client1.setAddress("123 Main St");
        client1.setPhoneNumber("555-1234");
        client1.setEmail("john.doe@example.com");
        clientRepository.save(client1);

        city1.getClients().add(client1);
        clientRepository.save(client1);

    //Client 2
        Client client2 = new Client();
        client2.setIdClient("C002");
        client2.setRegistrationDate(new Date());
        client2.setCiClient("987654321");
        client2.setNameClient("Jane");
        client2.setLastNameClient("Smith");
        client2.setCity(city2);
        client2.setAddress("456 Elm St");
        client2.setPhoneNumber("555-5678");
        client2.setEmail("jane.smith@example.com");
        clientRepository.save(client2);

        city2.getClients().add((client2));
        clientRepository.save(client2);

    //Clients 3
        Client client3 = new Client();
        client3.setIdClient("C003");
        client3.setRegistrationDate(new Date());
        client3.setCiClient("456789123");
        client3.setNameClient("Alice");
        client3.setLastNameClient("Johnson");
        client3.setCity(city4);
        client3.setAddress("789 Maple Ave");
        client3.setPhoneNumber("555-9101");
        client3.setEmail("alice.johnson@example.com");
        clientRepository.save(client3);

        city4.getClients().add(client3);
        clientRepository.save(client3);

    //Client4
        Client client4 = new Client();
        client4.setIdClient("C004");
        client4.setRegistrationDate(new Date());
        client4.setCiClient("321654987");
        client4.setNameClient("Bob");
        client4.setLastNameClient("Williams");
        client4.setCity(city5);
        client4.setAddress("321 Oak Dr");
        client4.setPhoneNumber("555-6789");
        client4.setEmail("bob.williams@example.com");
        clientRepository.save(client4);

        city5.getClients().add(client4);
        clientRepository.save(client4);

    //Seller1
        Seller seller1 = new Seller();
        seller1.setIdSeller("S001");
        seller1.setRegistrationDate(new Date());
        seller1.setCiSeller("123456789");
        seller1.setNameSeller("Alice");
        seller1.setLastNameSeller("Johnson");
        seller1.setCity(city3);
        seller1.setAddress("123 Maple Ave");
        seller1.setPhoneNumber("555-1234");
        seller1.setEmail("alice.johnson@example.com");
        sellerRepository.save(seller1);

        city3.getSellers().add(seller1);
        sellerRepository.save(seller1);

    //Seller2
        Seller seller2 = new Seller();
        seller2.setIdSeller("S002");
        seller2.setRegistrationDate(new Date());
        seller2.setCiSeller("234567890");
        seller2.setNameSeller("Bob");
        seller2.setLastNameSeller("Williams");
        seller2.setCity(city2);
        seller2.setAddress("456 Oak St");
        seller2.setPhoneNumber("555-5678");
        seller2.setEmail("bob.williams@example.com");
        sellerRepository.save(seller2);

        city2.getSellers().add(seller2);
        sellerRepository.save(seller2);

    //Seller3
        Seller seller3 = new Seller();
        seller3.setIdSeller("S003");
        seller3.setRegistrationDate(new Date());
        seller3.setCiSeller("345678901");
        seller3.setNameSeller("Carol");
        seller3.setLastNameSeller("Davis");
        seller3.setCity(city3);
        seller3.setAddress("789 Pine St");
        seller3.setPhoneNumber("555-9012");
        seller3.setEmail("carol.davis@example.com");
        sellerRepository.save(seller3);

        city3.getSellers().add(seller3);
        sellerRepository.save(seller3);

    //Seller4
        Seller seller4 = new Seller();
        seller4.setIdSeller("S004");
        seller4.setRegistrationDate(new Date());
        seller4.setCiSeller("456789012");
        seller4.setNameSeller("David");
        seller4.setLastNameSeller("Brown");
        seller4.setCity(city2);
        seller4.setAddress("101 Birch St");
        seller4.setPhoneNumber("555-3456");
        seller4.setEmail("david.brown@example.com");
        sellerRepository.save(seller4);

        city2.getSellers().add(seller4);
        sellerRepository.save(seller4);

    //Supplier1
        Supplier supplier1 = new Supplier();
        supplier1.setIdSupplier("SUP001");
        supplier1.setRucSupplier("0012345678001");
        supplier1.setNameSupplier("Tech Supplies Inc.");
        supplier1.setAddress("123 Tech Rd");
        supplier1.setCity(city1);
        supplier1.setPhoneNumber("555-1111");
        supplier1.setEmail("contact@techsupplies.com");
        supplierRepository.save(supplier1);

        city1.getSuppliers().add(supplier1);
        supplierRepository.save(supplier1);

    //Supplier2
        Supplier supplier2 = new Supplier();
        supplier2.setIdSupplier("SUP002");
        supplier2.setRucSupplier("0012345678002");
        supplier2.setNameSupplier("Office Goods Ltd.");
        supplier2.setAddress("456 Office St");
        supplier2.setCity(city2);
        supplier2.setPhoneNumber("555-2222");
        supplier2.setEmail("info@officegoods.com");
        supplierRepository.save(supplier2);

        city2.getSuppliers().add(supplier2);
        supplierRepository.save(supplier2);

    //Supplier3

        Supplier supplier3 = new Supplier();
        supplier3.setIdSupplier("SUP003");
        supplier3.setRucSupplier("0012345678003");
        supplier3.setNameSupplier("Furniture World");
        supplier3.setAddress("789 Furniture Ave");
        supplier3.setCity(city3);
        supplier3.setPhoneNumber("555-3333");
        supplier3.setEmail("sales@furnitureworld.com");
        supplierRepository.save(supplier3);

        city3.getSuppliers().add(supplier3);
        supplierRepository.save(supplier3);

    //Supplier4
        Supplier supplier4 = new Supplier();
        supplier4.setIdSupplier("SUP004");
        supplier4.setRucSupplier("0012345678004");
        supplier4.setNameSupplier("Clean Solutions Co.");
        supplier4.setAddress("101 Clean St");
        supplier4.setCity(city4);
        supplier4.setPhoneNumber("555-4444");
        supplier4.setEmail("support@clean-solutions.com");
        supplierRepository.save(supplier4);

        city5.getSuppliers().add(supplier4);
        supplierRepository.save(supplier4);

    //Product1
        Product product1 = new Product();
        product1.setIdProduct("P001");
        product1.setNameProduct("Product A");
        product1.setSupplier(supplier1);
        product1.setDetailProduct("Product Description A");
        product1.setPrice(11.00);
        productRepository.save(product1);

        supplier1.getProducts().add(product1);
        productRepository.save(product1);

    //Product2
        Product product2 = new Product();
        product2.setIdProduct("P002");
        product2.setNameProduct("Product B");
        product2.setSupplier(supplier4);
        product2.setDetailProduct("Product Description B");
        product2.setPrice(15.00);
        productRepository.save(product2);

        supplier4.getProducts().add(product2);
        productRepository.save(product2);

    //Product3
        Product product3 = new Product();
        product3.setIdProduct("P003");
        product3.setNameProduct("Product C");
        product3.setSupplier(supplier2);
        product3.setDetailProduct("Product Description C");
        product3.setPrice(8.00);
        productRepository.save(product3);

        supplier2.getProducts().add(product3);
        productRepository.save(product3);

    //Product4
        Product product4 = new Product();
        product4.setIdProduct("P004");
        product4.setNameProduct("Product D");
        product4.setSupplier(supplier3);
        product4.setDetailProduct("Product Description D");
        product4.setPrice(12.00);
        productRepository.save(product4);

        supplier3.getProducts().add(product4);
        productRepository.save(product4);


    //Product5
        Product product5 = new Product();
        product5.setIdProduct("P005");
        product5.setNameProduct("Product E");
        product5.setSupplier(supplier1);
        product5.setDetailProduct("Product Description E");
        product5.setPrice(10.00);
        productRepository.save(product5);

        supplier1.getProducts().add(product5);
        productRepository.save(product5);

    //Invoice
        Invoice invoice1 = new Invoice();
        invoice1.setInvoiceId("INV001");
        invoice1.setIssueDate("2024-08-01");
        invoice1.setSupplier(supplier1);
        invoice1.setClient(client1);
        invoice1.setAmountTotal(4);
        invoice1.setSubTotal(44.00);
        invoice1.setTotal(50.6);
        invoice1.setSeller(seller3);
        invoice1.setPayMethod(payMethod2);
        invoiceRepository.save(invoice1);

        supplier1.getInvoices().add(invoice1);
        client1.getInvoices().add(invoice1);
        seller3.getInvoices().add(invoice1);
        payMethod2.getInvoices().add(invoice1);
        invoiceRepository.save(invoice1);

        Invoice invoice2 = new Invoice();
        invoice2.setInvoiceId("INV002");
        invoice2.setIssueDate("2024-08-02");
        invoice2.setSupplier(supplier3);
        invoice2.setClient(client3);
        invoice2.setAmountTotal(5);
        invoice2.setSubTotal(46.00);
        invoice2.setTotal(52.90);
        invoice2.setSeller(seller1);
        invoice2.setPayMethod(payMethod1);
        invoiceRepository.save(invoice2);

        supplier3.getInvoices().add(invoice2);
        client3.getInvoices().add(invoice2);
        seller1.getInvoices().add(invoice2);
        payMethod1.getInvoices().add(invoice2);
        invoiceRepository.save(invoice2);


        //Invoice Detail
        InvoiceDetail invoiceDetail1 = new InvoiceDetail();
        invoiceDetail1.setInvoiceDetailId("D001");
        invoiceDetail1.setInvoice(invoice1);
        invoiceDetail1.setProduct(product1);
        invoiceDetail1.setAmount("4");
        invoiceDetail1.setSubtotal(44.00);
        invoiceDetail1.setIva(6.60);
        invoiceDetail1.setTotal(50.60);
        invoiceDetailRepository.save(invoiceDetail1);

        invoice1.getInvoiceDetails().add(invoiceDetail1);
        product1.getInvoiceDetails().add(invoiceDetail1);
        invoiceDetailRepository.save(invoiceDetail1);

        InvoiceDetail invoiceDetail2 = new InvoiceDetail();
        invoiceDetail2.setInvoiceDetailId("D002");
        invoiceDetail2.setInvoice(invoice2);
        invoiceDetail2.setProduct(product5);
        invoiceDetail2.setAmount("3");
        invoiceDetail2.setSubtotal(30.00);
        invoiceDetail2.setIva(4.50);
        invoiceDetail2.setTotal(34.50);
        invoiceDetailRepository.save(invoiceDetail2);

        invoice2.getInvoiceDetails().add(invoiceDetail2);
        product5.getInvoiceDetails().add(invoiceDetail2);
        invoiceDetailRepository.save(invoiceDetail2);

        InvoiceDetail invoiceDetail3 = new InvoiceDetail();
        invoiceDetail3.setInvoiceDetailId("D003");
        invoiceDetail3.setInvoice(invoice2);
        invoiceDetail3.setProduct(product3);
        invoiceDetail3.setAmount("2");
        invoiceDetail3.setSubtotal(44.00);
        invoiceDetail3.setIva(2.40);
        invoiceDetail3.setTotal(18.40);
        invoiceDetailRepository.save(invoiceDetail3);

        invoice2.getInvoiceDetails().add(invoiceDetail3);
        product3.getInvoiceDetails().add(invoiceDetail3);
        invoiceDetailRepository.save(invoiceDetail3);

        System.out.println("--------- Started BootstrapData ---------");
            System.out.println("Number of Cities: " +cityRepository.count());
            System.out.println("Number of PayMethods: " +payMethodRepository.count());
            System.out.println("Number of Branches: " +branchRepository.count());
            System.out.println("Number of Clients: " +clientRepository.count());
            System.out.println("Number of Seller: " +sellerRepository.count());
            System.out.println("Number of Supplier: " +supplierRepository.count());
            System.out.println("Number of Product: " +productRepository.count());
            System.out.println("Number of Invoice: " +invoiceRepository.count());
            System.out.println("Number of InvoiceDetail: " +invoiceDetailRepository.count());

    }
}
