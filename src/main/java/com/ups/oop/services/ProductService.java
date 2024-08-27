package com.ups.oop.services;

import com.ups.oop.dto.ProductDTO;
import com.ups.oop.entities.Product;
import com.ups.oop.entities.Supplier;
import com.ups.oop.repository.ProductRepository;
import com.ups.oop.repository.SupplierRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public ProductService(ProductRepository productRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    private List<ProductDTO> productList = new ArrayList<>();

    public ResponseEntity createProduct(ProductDTO productDTO){

        String productId = productDTO.getIdProduct();

        Optional<Product> productOptional = productRepository.findByProductId(productId);

        if(productOptional.isPresent()){

            String errorMessage = "Product with id " + productId + " already exists.";

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);

        }else{
            Optional<Supplier> supplierOptional = supplierRepository.findByNameSupplier(productDTO.getSupplier());

            if(supplierOptional.isPresent()){
            Product product = new Product();
            product.setIdProduct(productId);
            product.setNameProduct(productDTO.getNameProduct());
            product.setIdSupplier(supplierOptional.get());
            product.setDetailProduct(productDTO.getDetailProduct());
            product.setPrice(Double.parseDouble(productDTO.getPrice()));

            return ResponseEntity.status(HttpStatus.OK).body(product);

            }else{

                String errorMessage = "Supplier don't exists.";

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        }
    }

    public ResponseEntity getAllProducts() {

        Iterable<Product> productIterable = productRepository.findAll();

        List<ProductDTO> productList = new ArrayList<>();

        for (Product p : productIterable) {

            ProductDTO product = new ProductDTO(p.getIdProduct(),p.getNameProduct(),
                    p.getIdSupplier().getNameSupplier(),p.getDetailProduct(),String.valueOf(p.getPrice()));

            productList.add(product);
        }

        if (productList.isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products List not found");

        }

        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    public ResponseEntity getProductById(String idProduct){

        Optional<Product> productOptional = productRepository.findByProductId(idProduct);

        if(productOptional.isPresent()){

            Product productFound = productOptional.get();

            ProductDTO product = new ProductDTO(productFound.getIdProduct(),productFound.getNameProduct(),
                    productFound.getIdSupplier().getNameSupplier(),productFound.getDetailProduct(),String.valueOf(productFound.getPrice()));

            return ResponseEntity.status(HttpStatus.OK).body(product);

        }else{
            String errorMessage = "Product with id " + idProduct + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity updateProduct(ProductDTO productDTO){

        String productId = productDTO.getIdProduct();

        Optional<Product> productOptional = productRepository.findByProductId(productId);

        if(productOptional.isPresent()){

            Optional<Supplier> supplierOptional = supplierRepository.findByNameSupplier(productDTO.getSupplier());

            if(supplierOptional.isPresent()){
                Product product = new Product();
                product.setIdProduct(productId);
                product.setNameProduct(productDTO.getNameProduct());
                product.setIdSupplier(supplierOptional.get());
                product.setDetailProduct(productDTO.getDetailProduct());
                product.setPrice(Double.parseDouble(productDTO.getPrice()));

                return ResponseEntity.status(HttpStatus.OK).body(product);

            }else{

                String errorMessage = "Supplier don't exists.";

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }

        }else{
            String errorMessage = "Product with id " + productId + " already exists.";

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    public ResponseEntity deleteProductById(String id){

        String message = "Product with id " + id;

        Optional<Product> productOptional = productRepository.findByProductId(id);

        if(productOptional.isPresent()){

            productRepository.delete((productOptional.get()));

            return ResponseEntity.status(HttpStatus.OK).body(message + " removed successufuly");

        }else{

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message + " not found");

        }
    }

}
