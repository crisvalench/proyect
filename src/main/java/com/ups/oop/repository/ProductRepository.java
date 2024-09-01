package com.ups.oop.repository;

import com.ups.oop.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Optional<Product> findByIdProduct(String idProduct);

}
