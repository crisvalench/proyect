package com.ups.oop.repository;

import com.ups.oop.entities.Branch;
import org.springframework.data.repository.CrudRepository;

public interface branchRepository extends CrudRepository<Branch, Long> {
}
