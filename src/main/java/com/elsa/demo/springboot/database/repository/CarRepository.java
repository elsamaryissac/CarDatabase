package com.elsa.demo.springboot.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elsa.demo.springboot.database.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{

}
