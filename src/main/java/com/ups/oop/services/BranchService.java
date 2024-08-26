package com.ups.oop.services;

import com.ups.oop.dto.BranchDTO;
import com.ups.oop.entities.Branch;
import com.ups.oop.entities.City;
import com.ups.oop.repository.BranchRepository;
import com.ups.oop.repository.CityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BranchService {
    private final BranchRepository branchRepository;
    private final CityRepository cityRepository;


    public BranchService(BranchRepository branchRepository, CityRepository cityRepository) {
        this.branchRepository = branchRepository;
        this.cityRepository = cityRepository;
    }

    private List<BranchDTO> branchDTOList = new ArrayList<>();

    public ResponseEntity createBranch(BranchDTO branchDTO){
        String idBranch = branchDTO.getIdBranch();
        Optional<Branch> branchOptional = branchRepository.findByIdBranch(idBranch);

        if(branchOptional.isPresent()){
            String errorMessage = "Branch with id " + idBranch + " already exists.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }else{
            Optional<City> cityOptional = cityRepository.findByNameCity(branchDTO.getCity());
            if(cityOptional.isPresent()){
                    Branch branch = new Branch();
                    branch.setIdBranch(idBranch);
                    branch.setRegistrationDate(new Date(branchDTO.getRegistrationDate()));
                    branch.setNameBranch(branchDTO.getNameBranch());
                    branch.setIdCity(cityOptional.get());
                    branch.setAddress(branchDTO.getAddress());
                    branch.setPhoneNumber(branchDTO.getPhoneNumber());
                    branch.setEmail(branchDTO.getPhoneNumber());
                    return ResponseEntity.status(HttpStatus.OK).body(branch);
            }else{
                    String errorMessage = "City don't exists.";
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
                }
        }
    }

    public ResponseEntity getAllBranches() {
        Iterable<Branch> branchIterable = branchRepository.findAll();
        List<BranchDTO> branchesList = new ArrayList<>();

        for (Branch b : branchIterable) {
            BranchDTO branch = new BranchDTO(b.getIdBranch(), b.getRegistrationDate().toString(), b.getNameBranch(), b.getIdCity().getNameCity(), b.getAddress(), b.getPhoneNumber(), b.getEmail());
            branchesList.add(branch);
        }
        if (branchesList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Branch List not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(branchesList);
    }

    public ResponseEntity getBranchById(String idBranch){
        Optional<Branch> branchOptional = branchRepository.findByIdBranch(idBranch);
        if(branchOptional.isPresent()){
            Branch branchFound = branchOptional.get();
            BranchDTO branch = new BranchDTO(branchFound.getIdBranch(), branchFound.getRegistrationDate().toString(),
                    branchFound.getNameBranch(),branchFound.getIdCity().getNameCity(),branchFound.getAddress(),branchFound.getPhoneNumber(),branchFound.getEmail());
            return ResponseEntity.status(HttpStatus.OK).body(branch);

        }else{
            String errorMessage = "Person with id " + idBranch + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity updateBranch(BranchDTO branchDTO) {
        String idBranch = branchDTO.getIdBranch();
        Optional<Branch> branchOptional = branchRepository.findByIdBranch(idBranch);
        if (branchOptional.isPresent()) {
            Optional<City> cityOptional = cityRepository.findByNameCity(branchDTO.getCity());
            if (cityOptional.isPresent()) {
                Branch branch = branchOptional.get();
                branch.setIdBranch(idBranch);
                branch.setRegistrationDate(new Date(branchDTO.getRegistrationDate()));
                branch.setNameBranch(branchDTO.getNameBranch());
                branch.setIdCity(cityOptional.get());
                branch.setAddress(branchDTO.getAddress());
                branch.setPhoneNumber(branchDTO.getPhoneNumber());
                branch.setEmail(branchDTO.getPhoneNumber());
                branchRepository.save(branch);
            } else {
                String errorMessage = "City don't exists.";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Branch with id " + idBranch + " doesn't exits");
        }
    }

    public ResponseEntity deleteBranchById(String id){
         String message = "Branch with id " + id;
         Optional<Branch> branchOptional = branchRepository.findByIdBranch(id);
          if(branchOptional.isPresent()){
              branchRepository.delete((branchOptional.get()));
              return ResponseEntity.status(HttpStatus.OK).body(message + " removed successufuly");
          }else{
              return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message + " not found");
          }

     }
}
