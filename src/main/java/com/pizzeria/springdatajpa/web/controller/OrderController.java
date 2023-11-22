/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pizzeria.springdatajpa.web.controller;

import com.pizzeria.springdatajpa.persistence.entity.OrderEntity;
import com.pizzeria.springdatajpa.persistence.projection.OrderSummary;
import com.pizzeria.springdatajpa.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edwin
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    
    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAll(){
        return ResponseEntity.ok(this.orderService.getAll());
    }
    
    @GetMapping("/today")
    public ResponseEntity<List<OrderEntity>> getTodayOrder(){
        return ResponseEntity.ok(this.orderService.getTodayOrder());
    }
    
    @GetMapping("/outside")
    public ResponseEntity<List<OrderEntity>> getOutSideOrder(){
        return ResponseEntity.ok(this.orderService.getOutSideOrder());
    }
    
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderEntity>> getCustomerOrders(@PathVariable String customerId){
        return ResponseEntity.ok(this.orderService.getCustomerOrders(customerId));
    }
    
    @GetMapping("/sumary/{orderId}")
    public ResponseEntity<OrderSummary> getSumary(@PathVariable int orderId){
        return ResponseEntity.ok(this.orderService.getSumary(orderId));
    }
    
}
