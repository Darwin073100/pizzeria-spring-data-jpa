package com.pizzeria.springdatajpa.web.controller;

import com.pizzeria.springdatajpa.persistence.entity.CustomerEntity;
import com.pizzeria.springdatajpa.persistence.entity.OrderEntity;
import com.pizzeria.springdatajpa.service.CustomerService;
import com.pizzeria.springdatajpa.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author edwin
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    
    private final CustomerService customerService;
    private final OrderService orderService;

    @Autowired
    public CustomerController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }
    
    @GetMapping("/phone/{phone}")
    public ResponseEntity<CustomerEntity> getByPhone(@PathVariable String phone){
        return ResponseEntity.ok(this.customerService.getByPhone(phone));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderEntity>> getCustomerOrders(@PathVariable String customerId){
        return ResponseEntity.ok(this.orderService.getCustomerOrders(customerId));
    }
    
}
