package com.ups.oop.controller;

import com.ups.oop.dto.SellerDTO;
import com.ups.oop.services.SellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerController {
    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping("/seller")
    public ResponseEntity createSeller(@RequestBody SellerDTO sellerDTO){
        return this.sellerService.createSeller(sellerDTO);
    }

    @GetMapping("/get-all-sellers")
    public ResponseEntity getAllSellers(){
        return this.sellerService.getAllSellers();
    }

    @GetMapping("/get-seller")
    public ResponseEntity getSellerById(@RequestParam String id){
        return this.sellerService.getSellerById(id);
    }

    @PutMapping("/update-seller")
    public ResponseEntity updateSeller(@RequestBody SellerDTO sellerDTO){
        return this.sellerService.updateSeller(sellerDTO);
    }

    @DeleteMapping("remove-seller")
    public ResponseEntity deleteSeller(@RequestParam String id){
        return this.sellerService.deleteSeller(id);
    }
}
