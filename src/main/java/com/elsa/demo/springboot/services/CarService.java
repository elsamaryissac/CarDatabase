package com.elsa.demo.springboot.services;

import java.util.List;

import com.elsa.demo.springboot.model.Car;

public interface CarService {
	public Car addCar(Car car);
	public List<Car> getCarList();
	public Car get(Integer id);
	public Car get(String company);
	
}
