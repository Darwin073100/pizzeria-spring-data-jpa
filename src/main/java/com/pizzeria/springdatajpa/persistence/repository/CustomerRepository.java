package com.pizzeria.springdatajpa.persistence.repository;

import com.pizzeria.springdatajpa.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author edwin
 */
public interface CustomerRepository extends ListCrudRepository<CustomerEntity, String> {
    
    @Query(value = "SELECT c FROM CustomerEntity c WHERE(c.phoneNumber = :phone)")
    public CustomerEntity findByPhone(@Param(value = "phone") String phone);
}
