package com.ups.oop.repository;

import com.ups.oop.entities.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Optional<Client> findByIdClient(String idClient);

}
