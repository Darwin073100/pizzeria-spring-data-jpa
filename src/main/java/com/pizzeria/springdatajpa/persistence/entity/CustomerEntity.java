package com.pizzeria.springdatajpa.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author edwin
 */
@Entity
@Table(name = "customer")
@Getter
@Setter
public class CustomerEntity {
    @Id
    @Column(name = "customer_id", length = 15,nullable = false)
    private String custumerId;
    @Column(nullable = false, length = 60)
    private String name;
    @Column(nullable = false, length = 100)
    private String address;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @Column(name = "phone_number",length = 20)
    private String phoneNumber;
}
