/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pizzeria.springdatajpa.persistence.repository;
import com.pizzeria.springdatajpa.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;
/**
 *
 * @author edwin
 */
public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer>{
    
}
