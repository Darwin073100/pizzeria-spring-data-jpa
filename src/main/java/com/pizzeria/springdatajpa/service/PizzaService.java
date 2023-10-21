package com.pizzeria.springdatajpa.service;

import com.pizzeria.springdatajpa.persistence.entity.PizzaEntity;
import com.pizzeria.springdatajpa.persistence.repository.PizzaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edwin
 */
@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<PizzaEntity> getAll(){
        return this.pizzaRepository.findAll();
    }
    
    public PizzaEntity getById(int pizzaId){
        return this.pizzaRepository.findById(pizzaId).orElse(null);
    }
    
    public PizzaEntity save(PizzaEntity pizza){
        return this.pizzaRepository.save(pizza);
    }
    
    public boolean exists(int pizzaId){
        return this.pizzaRepository.existsById(pizzaId);
    }
    
    public void delete(int pizzaId){
        this.pizzaRepository.deleteById(pizzaId);
    }
    
}
