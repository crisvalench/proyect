package com.ups.oop.services;

import com.ups.oop.dto.BranchDTO;
import com.ups.oop.dto.CityDTO;
import com.ups.oop.entities.Branch;
import com.ups.oop.entities.City;
import com.ups.oop.dto.SellerDTO;
import com.ups.oop.repository.BranchRepository;
import com.ups.oop.repository.CityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityService {
    private final CityRepository cityRepository;
    private final BranchRepository branchRepository;

    public CityService(CityRepository cityRepository, BranchRepository branchRepository) {
        this.cityRepository = cityRepository;
        this.branchRepository = branchRepository;
    }

    private List<CityDTO> cityDTOList = new ArrayList<>();

    public ResponseEntity createCity(CityDTO cityDTO, SellerDTO sellerDTO) {
        String cityId = cityDTO.getIdCity();

        Optional<City> cityOptional = cityRepository.findByCityId(cityId);

        if (cityOptional.isPresent()) {
            String errorMessage = "City with id " + cityId + " already exists.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            City city = new City();
            //city.setIdCity(cityId);
            //city.setNameCity(cityDTO.getNameCity());
            //city.setBranches(cityDTO.getBranches());
            //city.setClients();
            //city.setSeller(cityDTO.getSeller(sellerDTO.setIdSeller()));
            //city.setSuppliers();

            cityRepository.save(city);
            return ResponseEntity.status(HttpStatus.OK).body(city);
        }
    }

    public ResponseEntity getAllCities(){
        Iterable<City> cityIterable = cityRepository.findAll();
        List<CityDTO> citiesList = new ArrayList<>();

        for (City c : cityIterable) {
            //CityDTO city = new CityDTO(c.getIdCity(), c.getNameCity(), c.getBranches(), c.getClients(),c.getBranches(),c.getSeller().toString(),c.getSuppliers());
            //citiesList.add(city);
        }
        if (citiesList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cities List not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(citiesList);
    }

    public ResponseEntity get
}