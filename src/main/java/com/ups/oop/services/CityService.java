package com.ups.oop.services;

import com.ups.oop.dto.CityDTO;
import com.ups.oop.entities.City;
import com.ups.oop.repository.CityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {

        this.cityRepository = cityRepository;
    }

    private List<CityDTO> cityDTOList = new ArrayList<>();

    public ResponseEntity createCity(CityDTO cityDTO) {

        String cityId = cityDTO.getIdCity();

        Optional<City> cityOptional = cityRepository.findByCityId(cityId);

        if (cityOptional.isPresent()) {

            String errorMessage = "City with id " + cityId + " already exists.";

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);

        } else {
            City city = new City();
            city.setIdCity(cityId);
            city.setNameCity(cityDTO.getNameCity());
            cityRepository.save(city);
            return ResponseEntity.status(HttpStatus.OK).body(city);
        }
    }

    public ResponseEntity getAllCities(){

        Iterable<City> cityIterable = cityRepository.findAll();

        List<CityDTO> citiesList = new ArrayList<>();

        for (City c : cityIterable) {
            CityDTO city = new CityDTO(c.getIdCity(), c.getNameCity());
            citiesList.add(city);
        }
        if (citiesList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cities List not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(citiesList);
    }

    public ResponseEntity getCityById(String cityId){
        Optional<City> cityOptional = cityRepository.findByCityId(cityId);

        if(cityOptional.isPresent()){
            City cityFound = cityOptional.get();
            CityDTO city = new CityDTO(cityFound.getIdCity(),cityFound.getNameCity());

            return ResponseEntity.status(HttpStatus.OK).body(city);
        }else{
            String errorMessage = "City with id " + cityId + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity updateCity(CityDTO cityDTO){

        String idCity = cityDTO.getIdCity();

        Optional<City> cityOptional = cityRepository.findByCityId(idCity);

        if(cityOptional.isPresent()){

            City city = cityOptional.get();
            city.setIdCity(idCity);
            city.setNameCity(cityDTO.getNameCity());

            cityRepository.save(city);

            return ResponseEntity.status(HttpStatus.OK).body(cityDTO);

        }else{

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("City with id " + idCity + " doesn't exits");

        }
    }

    public ResponseEntity deleteCityById(String id){

        String message = "City with id " + id;

        Optional<City> cityOptional = cityRepository.findByCityId(id);

        if(cityOptional.isPresent()){

            cityRepository.delete((cityOptional.get()));

            return ResponseEntity.status(HttpStatus.OK).body(message + " removed successufuly");

        }else{

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message + " not found");

        }
    }
}