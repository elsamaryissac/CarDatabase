package com.elsa.demo.springboot.services;


import java.util.List;

import com.elsa.demo.springboot.model.Car;

public interface CarService {
	public Car addCar(Car car);
	public List<Car> getCarList();
	public Car get(Integer id);
	public Car get(String company);
	public Car updateCar(Car car);
	public Car deleteCar(Car car);
	public Car disableCar(Car car);
	public List<Car> getActiveCarsList();
	public List<Car> getByName(String name);
	public List<Car> getListByCompanyAndYear(String company, Integer year);
	public List<Car> getListByEngPowGreaterThan1000AndYr(Integer enginePower, Integer year);
}
