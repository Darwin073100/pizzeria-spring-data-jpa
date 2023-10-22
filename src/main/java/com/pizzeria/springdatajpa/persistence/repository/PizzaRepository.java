package com.pizzeria.springdatajpa.persistence.repository;
import com.pizzeria.springdatajpa.persistence.entity.PizzaEntity;
import java.util.List;
import org.springframework.data.repository.ListCrudRepository;
/**
 *
 * @author edwin
 */
public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer>{
    // query method, return all rows availables order asc
    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
    
    PizzaEntity findAllByAvailableTrueAndNameIgnoreCase(String name);
}
