package com.ups.oop.repository;

import com.ups.oop.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface clientRepository extends CrudRepository<Client, Long> {
}
