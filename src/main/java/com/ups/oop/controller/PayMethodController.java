package com.ups.oop.controller;
import com.ups.oop.dto.PayMethodDTO;
import com.ups.oop.services.PayMethodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayMethodController {
    private final PayMethodService payMethodService;

    public PayMethodController(PayMethodService payMethodService) {
        this.payMethodService = payMethodService;
    }

    @PostMapping("/pay-method")
    public ResponseEntity createPayMethod(@RequestBody PayMethodDTO payMethodDTO){
        return  this.payMethodService.createPayMethod(payMethodDTO);
    }

    @GetMapping("/get-all-pay-methods")
    public ResponseEntity getAllPayMethods(){
        return this.payMethodService.getAllPayMethods();
    }

    @GetMapping ("/get-pay-methods")
    public ResponseEntity getPayMethodsById(@RequestParam String id){
        return this.payMethodService.getPayMethodsById(id);
    }

    @PutMapping("/update-pay-mathods")
    public  ResponseEntity updatePayMethod(@RequestBody PayMethodDTO payMethodDTO){
        return this.payMethodService.updatePayMethod(payMethodDTO);
    }

    @DeleteMapping("/remove-pay-method")
    public ResponseEntity deletePayMethod(@RequestParam String id){
        return this.payMethodService.deletePayMethod(id);
    }
}
