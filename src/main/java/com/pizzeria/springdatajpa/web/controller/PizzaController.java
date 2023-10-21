package com.pizzeria.springdatajpa.web.controller;

import com.pizzeria.springdatajpa.persistence.entity.PizzaEntity;
import com.pizzeria.springdatajpa.service.PizzaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edwin
 */
@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
    
    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }
    
    @GetMapping
    public ResponseEntity<List<PizzaEntity>> getAll(){
        return ResponseEntity.ok(this.pizzaService.getAll());
    }
    
    @GetMapping("/{pizzaId}")
    public ResponseEntity<PizzaEntity> getById(@PathVariable int pizzaId){
        return ResponseEntity.ok(this.pizzaService.getById(pizzaId));
    }
    
    @PostMapping
    public ResponseEntity<PizzaEntity> save(@RequestBody PizzaEntity pizza){
        if(pizza.getPizzaId() == null || !this.pizzaService.exists(pizza.getPizzaId())){
            return ResponseEntity.ok(this.pizzaService.save(pizza));
        }
        return ResponseEntity.badRequest().build();
    }
    
    @PutMapping
    public ResponseEntity<PizzaEntity> update(@RequestBody PizzaEntity pizza){
        if(pizza.getPizzaId() != null || this.pizzaService.exists(pizza.getPizzaId())){
            return ResponseEntity.ok(this.pizzaService.save(pizza));
        }
        return ResponseEntity.badRequest().build();
    }
    
    @DeleteMapping("/{pizzaId}")
    public ResponseEntity<Void> delete(@PathVariable int pizzaId){
        if(this.pizzaService.exists(pizzaId)){
            this.pizzaService.delete(pizzaId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    

    
}
