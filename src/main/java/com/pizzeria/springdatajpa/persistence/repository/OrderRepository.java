package com.pizzeria.springdatajpa.persistence.repository;

import com.pizzeria.springdatajpa.persistence.entity.OrderEntity;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.repository.ListCrudRepository;

/**
 *
 * @author edwin
 */
public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer>{
    List<OrderEntity> findAllByDateAfter(LocalDateTime date);
    List<OrderEntity> findAllByMethodIn(List<String> methods);
}
