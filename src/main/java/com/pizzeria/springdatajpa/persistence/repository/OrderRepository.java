package com.pizzeria.springdatajpa.persistence.repository;

import com.pizzeria.springdatajpa.persistence.entity.OrderEntity;
import com.pizzeria.springdatajpa.persistence.projection.OrderSummary;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author edwin
 */
public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer>{
    List<OrderEntity> findAllByDateAfter(LocalDateTime date);
    List<OrderEntity> findAllByMethodIn(List<String> methods);
    
    @Query(value = "SELECT * FROM pizza_order WHERE(customer_id = :customerId)", nativeQuery = true)
    List<OrderEntity> findCustomerOrders(@Param(value = "customerId") String customerId);
    
    @Query(value = "SELECT po.order_id AS orderId, cu.name AS customerName, po.date AS orderDate, " +
                    "	  po.total AS orderTotal, GROUP_CONCAT(pi.name) AS pizzaNames " +
                    "FROM pizza_order po " +
                    "	 INNER JOIN customer cu ON po.customer_id = cu.customer_id " +
                    "    INNER JOIN order_item oi ON po.order_id = oi.order_id " +
                    "    INNER JOIN pizza pi ON oi.pizza_id = pi.pizza_id " +
                    "WHERE po.order_id = :orderId " +
                    "GROUP BY po.order_id, cu.name, po.date, po.total;", nativeQuery = true)
    OrderSummary findSumary(@Param( value = "orderId") int orderId);
}
