package com.pizzeria.springdatajpa.web.controller;

import com.pizzeria.springdatajpa.persistence.entity.PizzaEntity;
import com.pizzeria.springdatajpa.service.PizzaService;
import com.pizzeria.springdatajpa.service.dto.UpdatePizzaPriceDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    
//    @GetMapping
//    public ResponseEntity<List<PizzaEntity>> getAll(){
//        return ResponseEntity.ok(this.pizzaService.getAll());
//    }
    
    @GetMapping
    public ResponseEntity<Page<PizzaEntity>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int elements){
        return ResponseEntity.ok(this.pizzaService.getAll(page, elements));
    }
    
//    @GetMapping("/available")
//    public ResponseEntity<List<PizzaEntity>> getAvailable(){
//        return ResponseEntity.ok(this.pizzaService.getAvailable());
//    }
    
    @GetMapping("/available")
    // @CrossOrigin("http://localhost:3000/frond-end")
    public ResponseEntity<Page<PizzaEntity>> getAvailable(@RequestParam(defaultValue = "0") int page, 
                                                            @RequestParam(defaultValue = "4") int elements, 
                                                            @RequestParam(defaultValue = "price") String sortBy,
                                                            @RequestParam(defaultValue = "DESC") String sortDirection){
        return ResponseEntity.ok(this.pizzaService.getAvailable(page, elements, sortBy, sortDirection));
    }
    
    @GetMapping("/with/{ingredient}")
    public ResponseEntity<List<PizzaEntity>> getWith(@PathVariable String ingredient){
        return ResponseEntity.ok(this.pizzaService.getWith(ingredient));
    }
    
    @GetMapping("/without/{ingredient}")
    public ResponseEntity<List<PizzaEntity>> getWithout(@PathVariable String ingredient){
        return ResponseEntity.ok(this.pizzaService.getWithout(ingredient));
    }
    
    @GetMapping("/cheapest/{price}")
    public ResponseEntity<List<PizzaEntity>> getCheapest(@PathVariable double price){
        return ResponseEntity.ok(this.pizzaService.getCheapest(price));
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<PizzaEntity> getByName(@PathVariable String name){
        return ResponseEntity.ok(this.pizzaService.getByName(name));
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
    
    @PatchMapping("/price")
    public ResponseEntity<Void> updatePrice(@RequestBody UpdatePizzaPriceDto dto){
        if(pizzaService.exists(dto.getPizzaId())){
            this.pizzaService.updatePrice(dto);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    
}
