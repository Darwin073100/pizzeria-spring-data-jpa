package com.pizzeria.springdatajpa.persistence.repository;

import com.pizzeria.springdatajpa.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

/**
 *
 * @author edwin
 */
public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer>{
    
}
