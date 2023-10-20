package com.pizzeria.springdatajpa.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author edwin
 */
@Entity
@Table(name = "pizza")
@Getter
@Setter
public class PizzaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pizza_id", nullable = false)
    private Integer pizzaId;
    @Column(nullable = false, length = 30, unique = true)
    private String name;
    @Column(nullable = false, length = 150)
    private String description;
    @Column(nullable = false, columnDefinition = "Decimal(5,2)")
    private Double price;
    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean vegetarian;
    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean vegan;
    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean available;  
    
}
