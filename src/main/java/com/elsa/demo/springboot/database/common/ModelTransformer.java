package com.elsa.demo.springboot.database.common;

import com.elsa.demo.springboot.model.Car;

public class ModelTransformer {
public static Car toCarModel(com.elsa.demo.springboot.database.entity.Car car) {
	if(car == null) {
		return null;
	}
	Car newCar = new Car();
	newCar.setId(car.getId());
	newCar.setName(car.getName());
	newCar.setCompany(car.getCompany());
	newCar.setModified(car.getModified());
	newCar.setYear(car.getYear());
	newCar.setEnginePower(car.getEnginePower());
	newCar.setCreatedDate(car.getCreatedDate());
	newCar.setModifiedDate(car.getModifiedDate());
	newCar.setActive(car.isActive());
	return newCar;
}

public static com.elsa.demo.springboot.database.entity.Car toCarEntity(Car car) {
	if(car == null) {
		return null;
	}
	com.elsa.demo.springboot.database.entity.Car newCar = new com.elsa.demo.springboot.database.entity.Car();
	newCar.setName(car.getName());
	newCar.setCompany(car.getCompany());
	newCar.setModified(car.getModified());
	newCar.setYear(car.getYear());
	newCar.setEnginePower(car.getEnginePower());
	newCar.setCreatedDate(car.getCreatedDate());
	newCar.setModifiedDate(car.getModifiedDate());
	newCar.setActive(car.isActive());
	return newCar;
}

}
