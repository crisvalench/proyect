package com.ups.oop.controller;

import com.ups.oop.dto.ProductDTO;
import com.ups.oop.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity createProduct(@RequestBody ProductDTO productDTO){
        return this.productService.createProduct(productDTO);
    }

    @GetMapping("/get-all-product")
    public ResponseEntity getAllProducts(){
        return this.productService.getAllProducts();
    }

    @GetMapping("/get-product")
    public ResponseEntity getProductById(@RequestParam String id){
        return this.productService.getProductById(id);
    }

    @PutMapping("/update-product")
    public ResponseEntity updateProduct(@RequestBody ProductDTO productDTO){
        return this.productService.updateProduct(productDTO);
    }

    @DeleteMapping("/remove-product")
    public ResponseEntity deleteProductById(@RequestParam String id){
        return this.productService.deleteProductById(id);
    }
}
