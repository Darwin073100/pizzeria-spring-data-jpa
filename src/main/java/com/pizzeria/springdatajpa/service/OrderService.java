/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pizzeria.springdatajpa.service;

import com.pizzeria.springdatajpa.persistence.entity.OrderEntity;
import com.pizzeria.springdatajpa.persistence.repository.OrderRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edwin
 */
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    
    private static final String DELIVERY = "D";
    private static final String CARRYOUT = "C";
    private static final String ON_SITE = "S";
    
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    public List<OrderEntity> getAll(){
        return this.orderRepository.findAll();
    }
    
    public List<OrderEntity> getTodayOrder(){
        LocalDateTime today = LocalDate.now().atTime(0,0);
        return this.orderRepository.findAllByDateAfter(today);
    }
    
    public List<OrderEntity> getOutSideOrder(){
        List<String> methods = Arrays.asList(DELIVERY, CARRYOUT);
        return this.orderRepository.findAllByMethodIn(methods);
    }
}
