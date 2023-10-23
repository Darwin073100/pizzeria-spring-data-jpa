package com.pizzeria.springdatajpa.persistence.repository;
import com.pizzeria.springdatajpa.persistence.entity.PizzaEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.ListCrudRepository;
/**
 *
 * @author edwin
 */
public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer>{
    // query method, return all rows availables in asc order
    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
    
    // query method for returned pizzas available by name and asc order 
    Optional<PizzaEntity> findFirstByAvailableTrueAndNameIgnoreCase(String name);
    
    // query method, searched pizzas that include the ingredient specify
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);
    
    // query method, searched pizzas that don't include the ingredient specify
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
    
    List<PizzaEntity> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double prive);
    Integer countByVeganTrue();
}
