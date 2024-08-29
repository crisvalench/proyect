package com.ups.oop.repository;

import com.ups.oop.entities.Supplier;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
    Optional<Supplier> findByNameSupplier(String nameSupplier);
    Optional<Supplier> findByIdSupplier(String idSupplier);

}
