package com.ups.oop.controller;

import com.ups.oop.dto.SupplierDTO;
import com.ups.oop.services.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/supplier")
    public ResponseEntity createSupplier(@RequestBody SupplierDTO supplierDTO){
        return this.supplierService.createSupplier(supplierDTO);
    }

    @GetMapping("/get-all-suppliers")
    public ResponseEntity getAllSuppliers(){
        return this.supplierService.getAllSuppliers();
    }

    @GetMapping("/get-supplier")
    public ResponseEntity getSupplierById(@RequestParam String id){
        return this.supplierService.getSupplierById(id);
    }

    @PutMapping("update-supplier")
    public ResponseEntity updateSupplier(@RequestBody SupplierDTO supplierDTO){
        return this.supplierService.updateSupplier(supplierDTO);
    }

    @DeleteMapping("/remove-supplier")
    public ResponseEntity deleteSupplier(@RequestParam String id){
        return this.supplierService.deleteSupplier(id);
    }
}
