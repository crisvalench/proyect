package com.ups.oop.repository;

import com.ups.oop.entities.Seller;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SellerRepository extends CrudRepository<Seller, Long> {
    Optional<Seller> findBySellerId(String idClient);

}
