package com.ups.oop.services;


import com.ups.oop.dto.SupplierDTO;
import com.ups.oop.entities.City;
import com.ups.oop.entities.Supplier;
import com.ups.oop.repository.CityRepository;
import com.ups.oop.repository.SupplierRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;
    private final CityRepository cityRepository;

    public SupplierService(SupplierRepository supplierRepository, CityRepository cityRepository) {
        this.supplierRepository = supplierRepository;
        this.cityRepository = cityRepository;
    }

    private List<SupplierDTO> supplierList = new ArrayList<>();

    public ResponseEntity createSupplier(SupplierDTO supplierDTO){

        String supplierId = supplierDTO.getIdSupplier();

        Optional<Supplier> supplierOptional = supplierRepository.findByIdSupplier(supplierId);

        if(supplierOptional.isPresent()){

            String errorMessage = "Supplier with id " + supplierId + " already exists.";

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);

        }else{

            Optional<City> cityOptional = cityRepository.findByNameCity(supplierDTO.getCity());

            if (cityOptional.isPresent()) {

                Supplier supplier = new Supplier();
                supplier.setIdSupplier(supplierId);
                supplier.setRucSupplier(supplierDTO.getRucSupplier());
                supplier.setNameSupplier(supplierDTO.getNameSupplier());
                supplier.setCity(cityOptional.get());
                supplier.setAddress(supplierDTO.getAddress());
                supplier.setPhoneNumber(supplierDTO.getPhoneNumber());
                supplier.setEmail(supplierDTO.getEmail());

                supplierRepository.save(supplier);

                return ResponseEntity.status(HttpStatus.OK).body(supplier);
            }else{

                String errorMessage = "City don't exists.";

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);

            }
        }
    }

    public ResponseEntity getAllSuppliers(){

        Iterable<Supplier> supplierIterable = supplierRepository.findAll();

        List<SupplierDTO> supplierList = new ArrayList<>();

        for (Supplier sp : supplierIterable) {

            SupplierDTO supplier = new SupplierDTO(
                    sp.getIdSupplier(),sp.getRucSupplier(),sp.getNameSupplier(),sp.getCity().getNameCity(),sp.getAddress(),
                    sp.getPhoneNumber(),sp.getEmail());

            supplierList.add(supplier);
        }
        if (supplierList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier List not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(supplierList);
    }

    public ResponseEntity getSupplierById(String supplierId){

        Optional<Supplier> supplierOptional = supplierRepository.findByIdSupplier(supplierId);

        if(supplierOptional.isPresent()){

            Supplier supplierFound = supplierOptional.get();

            SupplierDTO supplier = new SupplierDTO(
                    supplierFound.getIdSupplier(), supplierFound.getRucSupplier(),supplierFound.getNameSupplier(),
                    supplierFound.getCity().getNameCity(),supplierFound.getAddress(),supplierFound.getPhoneNumber(),supplierFound.getEmail());

            return ResponseEntity.status(HttpStatus.OK).body(supplier);

        }else{

            String errorMessage = "Supplier with id " + supplierId + " not found.";

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity updateSupplier(SupplierDTO supplierDTO){

        String supplierId = supplierDTO.getIdSupplier();

        Optional<Supplier> supplierOptional = supplierRepository.findByIdSupplier(supplierId);

        if(supplierOptional.isPresent()){

            Optional<City> cityOptional = cityRepository.findByNameCity(supplierDTO.getCity());

            if (cityOptional.isPresent()) {

                Supplier supplier = new Supplier();
                supplier.setIdSupplier(supplierId);
                supplier.setRucSupplier(supplierDTO.getRucSupplier());
                supplier.setNameSupplier(supplierDTO.getNameSupplier());
                supplier.setCity(cityOptional.get());
                supplier.setAddress(supplierDTO.getAddress());
                supplier.setPhoneNumber(supplierDTO.getPhoneNumber());
                supplier.setEmail(supplierDTO.getEmail());

                supplierRepository.save(supplier);

                return ResponseEntity.status(HttpStatus.OK).body(supplier);

            }else{

                String errorMessage = "City don't exists.";

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);

            }

        }else{

            String errorMessage = "Supplier with id " + supplierId + " already exists.";

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);

        }
    }

    public ResponseEntity deleteSupplier(String id){

        String message = "Supplier with id " + id;

        Optional<Supplier> supplierOptional = supplierRepository.findByIdSupplier(id);

        if(supplierOptional.isPresent()){

            supplierRepository.delete((supplierOptional.get()));

            return ResponseEntity.status(HttpStatus.OK).body(message + " removed successufuly");

        }else{

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message + " not found");
        }
    }
}
