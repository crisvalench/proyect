package com.ups.oop.repository;

import com.ups.oop.entities.Seller;
import org.springframework.data.repository.CrudRepository;

public interface sellerRepository extends CrudRepository<Seller, Long> {
}
