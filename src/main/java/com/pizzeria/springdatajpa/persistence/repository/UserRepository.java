package com.pizzeria.springdatajpa.persistence.repository;

import com.pizzeria.springdatajpa.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {
}
