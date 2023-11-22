package com.pizzeria.springdatajpa.persistence.repository;
import com.pizzeria.springdatajpa.persistence.entity.PizzaEntity;
import com.pizzeria.springdatajpa.service.dto.UpdatePizzaPriceDto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
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
    
//    @Query(value = 
//            "UPDATE pizza " + 
//            "SET price = :newPrice " +
//            "WHERE(pizza_id = :pizzaId)", nativeQuery = true)
//    void updatePrice(@Param("pizzaId") int pizzaId, @Param("newPrice") double newPrice);
    
    @Modifying
    @Query(value = 
        "UPDATE pizza " + 
        "SET price = :#{#newPizzaPriceDto.newPrice} " +
        "WHERE(pizza_id = :#{#newPizzaPriceDto.pizzaId})", nativeQuery = true)
    void updatePrice(@Param("newPizzaPriceDto") UpdatePizzaPriceDto newPizzaPriceDto);
}
