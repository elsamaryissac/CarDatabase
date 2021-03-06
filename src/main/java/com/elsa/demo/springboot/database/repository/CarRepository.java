package com.elsa.demo.springboot.database.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elsa.demo.springboot.database.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{

	public List<Car> findByName(String carName);
	//public List<Car> findByEnginePowerGreaterThan(BigDecimal enginePower, Integer year);
}
