package com.pizzeria.springdatajpa.service.dto;

import lombok.Data;

/**
 *
 * @author edwin
 */
@Data
public class UpdatePizzaPriceDto {
    private int pizzaId;
    private double newPrice; 
}
