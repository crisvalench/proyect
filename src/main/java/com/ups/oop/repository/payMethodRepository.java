package com.ups.oop.repository;

import com.ups.oop.entities.PayMethod;
import org.springframework.data.repository.CrudRepository;

public interface payMethodRepository extends CrudRepository<PayMethod, Long> {
}
