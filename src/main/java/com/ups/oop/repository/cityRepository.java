package com.ups.oop.repository;

import com.ups.oop.entities.City;
import org.springframework.data.repository.CrudRepository;

public interface cityRepository extends CrudRepository<City, Long> {
}
