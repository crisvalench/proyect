package com.ups.oop.services;

import com.ups.oop.dto.SellerDTO;
import com.ups.oop.entities.City;
import com.ups.oop.entities.Seller;
import com.ups.oop.repository.CityRepository;
import com.ups.oop.repository.SellerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SellerService {
    private final SellerRepository sellerRepository;
    private final CityRepository cityRepository;

    public SellerService(SellerRepository sellerRepository, CityRepository cityRepository) {
        this.sellerRepository = sellerRepository;
        this.cityRepository = cityRepository;
    }

    private List<SellerDTO> sellerList = new ArrayList<>();

    public ResponseEntity createSeller(SellerDTO sellerDTO) {
        String sellerId = sellerDTO.getIdSeller();
        Optional<Seller> sellerOptional = sellerRepository.findByIdSeller(sellerId);

        if (sellerOptional.isPresent()) {
            String errorMessage = "Seller with id " + sellerId + " already exists.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            Optional<City> cityOptional = cityRepository.findByNameCity(sellerDTO.getCity());
            if (cityOptional.isPresent()) {
                Seller seller = new Seller();
                seller.setIdSeller(sellerId);
                seller.setRegistrationDate(new Date());
                seller.setCiSeller((sellerDTO.getCiSeller()));
                seller.setNameSeller(sellerDTO.getNameSeller());
                seller.setLastNameSeller(sellerDTO.getLastNameSeller());
                seller.setCity(cityOptional.get());
                seller.setAddress(sellerDTO.getAddress());
                seller.setPhoneNumber(sellerDTO.getPhoneNumber());
                seller.setEmail(sellerDTO.getEmail());
                return ResponseEntity.status(HttpStatus.OK).body(seller);
            } else {
                String errorMessage = "City don't exists.";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        }
    }

    public ResponseEntity getAllSellers() {
        Iterable<Seller> sellerIterable = sellerRepository.findAll();
        List<SellerDTO> sellerList = new ArrayList<>();

        for (Seller s : sellerIterable) {
            SellerDTO seller = new SellerDTO(s.getIdSeller(), s.getRegistrationDate().toString(),
                    s.getCiSeller(), s.getNameSeller(), s.getLastNameSeller(), s.getCity().getNameCity(),
                    s.getAddress(), s.getPhoneNumber(), s.getEmail());
            sellerList.add(seller);
        }
        if (sellerList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sellers List not found");
        }
            return ResponseEntity.status(HttpStatus.OK).body(sellerList);
    }

    //TemplateController
    public List<SellerDTO> getSellers(){
        Iterable<Seller> sellerIterable = sellerRepository.findAll();
        List<SellerDTO> sellerList = new ArrayList<>();
        for (Seller s : sellerIterable) {
            SellerDTO city = new SellerDTO(s.getIdSeller(), s.getRegistrationDate().toString(),
                    s.getCiSeller(), s.getNameSeller(), s.getLastNameSeller(), s.getCity().getNameCity(),
                    s.getAddress(), s.getPhoneNumber(), s.getEmail());
            sellerList.add(city);
        }
        return sellerList;
    }

    public ResponseEntity getSellerById(String sellerId){
        Optional<Seller> sellerOptional = sellerRepository.findByIdSeller(sellerId);

        if(sellerOptional.isPresent()){
            Seller sellerFound = sellerOptional.get();
            SellerDTO seller = new SellerDTO(
                    sellerFound.getIdSeller(),sellerFound.getRegistrationDate().toString(),
                    sellerFound.getCiSeller(),sellerFound.getNameSeller(),sellerFound.getLastNameSeller(),
                    sellerFound.getCity().getNameCity(),sellerFound.getAddress(),sellerFound.getPhoneNumber(),
                    sellerFound.getEmail());
            return ResponseEntity.status(HttpStatus.OK).body(seller);
        }else{
            String errorMessage = "Sellers with id " + sellerId + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity updateSeller(SellerDTO sellerDTO) {
        String sellerId = sellerDTO.getIdSeller();
        Optional<Seller> sellerOptional = sellerRepository.findByIdSeller(sellerId);

        if (sellerOptional.isPresent()) {
            Optional<City> cityOptional = cityRepository.findByNameCity(sellerDTO.getCity());
            if (cityOptional.isPresent()) {
                Seller seller = new Seller();
                seller.setIdSeller(sellerId);
                seller.setRegistrationDate(new Date(sellerDTO.getRegistrationDate()));
                seller.setCiSeller((sellerDTO.getCiSeller()));
                seller.setNameSeller(sellerDTO.getNameSeller());
                seller.setLastNameSeller(sellerDTO.getLastNameSeller());
                seller.setCity(cityOptional.get());
                seller.setAddress(sellerDTO.getAddress());
                seller.setPhoneNumber(sellerDTO.getPhoneNumber());
                seller.setEmail(sellerDTO.getEmail());
                return ResponseEntity.status(HttpStatus.OK).body(seller);
            } else {
                String errorMessage = "City don't exists.";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } else {
            String errorMessage = "Seller with id " + sellerId + " already exists.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    public ResponseEntity deleteSeller(String id){
        String message = "Seller with id " + id;
        Optional<Seller> sellerOptional = sellerRepository.findByIdSeller(id);

        if(sellerOptional.isPresent()){
            sellerRepository.delete((sellerOptional.get()));
            return ResponseEntity.status(HttpStatus.OK).body(message + " removed successufuly");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message + " not found");
        }
    }
}
