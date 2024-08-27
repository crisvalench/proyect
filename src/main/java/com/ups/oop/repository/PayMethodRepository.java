package com.ups.oop.repository;

import com.ups.oop.entities.PayMethod;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PayMethodRepository extends CrudRepository<PayMethod, Long> {
    Optional<PayMethod> findByPayMethId(String idPayMeth);

}
