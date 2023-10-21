package com.pizzeria.springdatajpa.persistence.repository;
import com.pizzeria.springdatajpa.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;
/**
 *
 * @author edwin
 */
public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer>{
    
}
