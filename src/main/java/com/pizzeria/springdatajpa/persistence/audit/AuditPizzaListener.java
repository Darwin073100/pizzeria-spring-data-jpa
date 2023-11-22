package com.pizzeria.springdatajpa.persistence.audit;

import com.pizzeria.springdatajpa.persistence.entity.PizzaEntity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import org.springframework.util.SerializationUtils;

/**
 *
 * @author edwin
 */
public class AuditPizzaListener {
    private PizzaEntity currentValue;
    
    @PostLoad
    public void postload(PizzaEntity entity){
        System.out.println("POST LOAD");
        this.currentValue = SerializationUtils.clone(entity);
    }
    
    @PostPersist
    @PostUpdate
    public void onPostPersiste(PizzaEntity entity){
        System.out.println("POST PERSIST UPDATE");
        System.out.println("OLD VALUE: " + this.currentValue.toString());
        System.out.println("NEW VALUE: " + entity.toString());
    }
    
    @PreRemove
    public void onPreDelete(PizzaEntity entity){
        System.out.println(entity.toString());
    }
}
