package com.elsa.demo.springboot.database.repository;

import org.springframework.data.repository.CrudRepository;

import com.elsa.demo.springboot.database.entity.Car;

public interface CarRepository extends CrudRepository<Car, Integer>{

}
