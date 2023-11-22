package com.pizzeria.springdatajpa.service;

import com.pizzeria.springdatajpa.persistence.entity.CustomerEntity;
import com.pizzeria.springdatajpa.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edwin
 */
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    public CustomerEntity getByPhone(String phone){
        return this.customerRepository.findByPhone(phone);
    }
}
