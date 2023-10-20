package com.pizzeria.springdatajpa.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author edwin
 */
@Entity
@Table(name = "order_item")
@IdClass(OrderItemId.class)
@Getter
@Setter
public class OrderItemEntity {
    @Id
    @Column(name = "item_id")
    private Integer itemId;
    @Id
    @Column(name = "order_id", nullable = false)
    private Integer orderId;
    @Column(name = "pizza_id", nullable = false)
    private Integer pizzaId;
    @Column(columnDefinition = "DECIMAL(2,1)", nullable = false)
    private Double quantity;
    @Column(columnDefinition = "DECIMAL(5, 2)", nullable = false)
    private Double price;
    
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", updatable = false, insertable = false)
    private OrderEntity order;
    
    @OneToOne
    @JoinColumn(name = "pizza_id", referencedColumnName = "pizza_id", updatable = false, insertable = false)
    private PizzaEntity pizza;
}
