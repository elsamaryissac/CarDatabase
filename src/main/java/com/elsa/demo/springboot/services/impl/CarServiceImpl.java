package com.elsa.demo.springboot.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsa.demo.springboot.component.CarDatabase;
import com.elsa.demo.springboot.model.Car;
import com.elsa.demo.springboot.services.CarService;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
	private CarDatabase carDatabase;
    
    
	@Override
	public Car addCar(Car car) {
		car.setCreatedDate(new Date());
		car.setModifiedDate(new Date());
		car.setId(getCount());
		car.setActive(true);
		carDatabase.add(car);
		return car;
	}

	@Override
	public List<Car> getCarList() {
		return carDatabase.getCarList();
	}
	
	@Override
	public List<Car> getActiveCarsList() {
		return carDatabase.getCarList().stream().filter(c->c.isActive()).collect(Collectors.toList());
	}

	private Integer getCount() {
		Integer count = 1;
		if (getCarList() != null) {
			count = getCarList().size() + 1;
		}
		return count;
	}

	@Override
	public Car get(Integer id) {
		return carDatabase.get(id);
		
	}
	
	public Car get(String company) {
		return carDatabase.get(company);
		
	}

	@Override
	public Car updateCar(Car car) {
		Car selectedCar=get(car.getId());
		selectedCar.setModifiedDate(new Date());
		if(!StringUtils.isEmpty(car.getName())) {
			selectedCar.setName(car.getName());
		}
		if(!StringUtils.isEmpty(car.getCompany())) {
			selectedCar.setCompany(car.getCompany());
		}
		if(car.getYear()!=null) {
			selectedCar.setYear(car.getYear());
		}
		return car;
	}

	@Override
	public Car deleteCar(Car car) {
		Car carToBeDeleted=get(car.getId());
			carDatabase.delete(carToBeDeleted);
			carDatabase.updateCarList();
		return car;
	}
	
	@Override
	public Car disableCar(Car car) {
		Car carToBeDeleted=get(car.getId());
		carToBeDeleted.setActive(false);
			carDatabase.updateCarList();
		return car;
	}
}
