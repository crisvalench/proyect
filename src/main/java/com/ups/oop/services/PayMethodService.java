package com.ups.oop.services;

import com.ups.oop.dto.PayMethodDTO;
import com.ups.oop.entities.PayMethod;
import com.ups.oop.repository.PayMethodRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PayMethodService {
    private final PayMethodRepository payMethodRepository;

    public PayMethodService(PayMethodRepository payMethodRepository) {
        this.payMethodRepository = payMethodRepository;
    }
    private List<PayMethodDTO> payMethodList = new ArrayList<>();

    public ResponseEntity createPayMethod(PayMethodDTO payMethodDTO) {
        String payMethodId = payMethodDTO.getIdPayMethod();
        Optional<PayMethod> payMethodOptional = payMethodRepository.findByIdPayMethod((payMethodId));

        if(payMethodOptional.isPresent()){
            String errorMessage = "Pay Method with id " + payMethodId + " already exists.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }else{
            PayMethod payMethod = new PayMethod();
            payMethod.setIdPayMethod(payMethodId);
            payMethod.setPayMethodName(payMethodDTO.getPayMethodName());
            payMethod.setDetail(payMethodDTO.getDetail());
            payMethodRepository.save(payMethod);
            return ResponseEntity.status(HttpStatus.OK).body(payMethod);
        }
    }

    public ResponseEntity getAllPayMethods(){
        Iterable<PayMethod> payMethodIterable = payMethodRepository.findAll();
        List<PayMethodDTO> payMethodList = new ArrayList<>();

        for (PayMethod pm : payMethodIterable) {
            PayMethodDTO payMethod = new PayMethodDTO(
                    pm.getIdPayMethod(),pm.getPayMethodName(),pm.getDetail());
            payMethodList.add(payMethod);
        }
        if (payMethodList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pay Methods List not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(payMethodList);
    }

    //TemplateController
    public List<PayMethodDTO> getPayMethods(){
        Iterable<PayMethod> payMethodIterable = payMethodRepository.findAll();
        List<PayMethodDTO> payMethodList = new ArrayList<>();
        for (PayMethod pm : payMethodIterable) {
            PayMethodDTO payMethod = new PayMethodDTO(pm.getIdPayMethod(),pm.getPayMethodName(),pm.getDetail());
            payMethodList.add(payMethod);
        }
        return payMethodList;
    }

    public ResponseEntity getPayMethodsById(String payMethodId) {
        Optional<PayMethod> payMethodOptional = payMethodRepository.findByIdPayMethod((payMethodId));

        if(payMethodOptional.isPresent()){
            PayMethod payMethodFound = payMethodOptional.get();
            PayMethodDTO payMethod = new PayMethodDTO(payMethodFound.getIdPayMethod(),payMethodFound.getPayMethodName(),
                    payMethodFound.getDetail());
            return ResponseEntity.status(HttpStatus.OK).body(payMethod);
        }else{
            String errorMessage = "Pay Method with id " + payMethodId + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity updatePayMethod(PayMethodDTO payMethodDTO){
        String payMethodId = payMethodDTO.getIdPayMethod();
        Optional<PayMethod> payMethodOptional = payMethodRepository.findByIdPayMethod((payMethodId));

        if(payMethodOptional.isPresent()){
            PayMethod payMethod = new PayMethod();
            payMethod.setIdPayMethod(payMethodId);
            payMethod.setPayMethodName(payMethodDTO.getPayMethodName());
            payMethod.setDetail(payMethodDTO.getDetail());
            payMethodRepository.save(payMethod);
            return ResponseEntity.status(HttpStatus.OK).body(payMethod);
        }else{
            String errorMessage = "Pay Method with id " + payMethodId + " already exists.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    public ResponseEntity deletePayMethod(String id){
        String message = "Pay Method with id " + id;
        Optional<PayMethod> payMethodOptional = payMethodRepository.findByIdPayMethod(id);

        if(payMethodOptional.isPresent()){
            payMethodRepository.delete((payMethodOptional.get()));
            return ResponseEntity.status(HttpStatus.OK).body(message + " removed successufuly");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message + " not found");
        }
    }
}
