package com.ups.oop.repository;

import com.ups.oop.entities.City;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CityRepository extends CrudRepository<City, Long> {
    Optional<City> findByNameCity(String nameCity);
    Optional<City> findByCityId(String idCity);
}
