package com.ups.oop.repository;

import com.ups.oop.entities.InvoiceDetail;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceDetailRepository extends CrudRepository<InvoiceDetail, Long> {
}
