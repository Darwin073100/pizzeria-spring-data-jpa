package com.pizzeria.springdatajpa.persistence.projection;

import java.time.LocalDateTime;

/**
 *
 * @author edwin
 */
public interface OrderSummary {
    Integer getOrderId();
    String getCustomerName();
    LocalDateTime getOrderDate();
    Double getOrderTotal();
    String getPizzaNames();
}
