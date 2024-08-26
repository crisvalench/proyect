package com.ups.oop.repository;

import com.ups.oop.entities.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
}
