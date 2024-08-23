package com.ups.oop.repository;

import com.ups.oop.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface productRepository extends CrudRepository<Product, Long> {
}
