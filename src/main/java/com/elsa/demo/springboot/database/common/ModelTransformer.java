package com.elsa.demo.springboot.database.common;

import java.util.ArrayList;
import java.util.List;

import com.elsa.demo.springboot.model.Car;
import com.elsa.demo.springboot.model.Owner;

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

public static Owner toOwnerModel(com.elsa.demo.springboot.database.entity.Owner owner) {
	if(owner == null) {
		return null;
	}
	Owner newOwner = new Owner();
	newOwner.setId(owner.getId());
	newOwner.setName(owner.getName());
	newOwner.setAge(owner.getAge());
	newOwner.setGender(owner.getGender());
	newOwner.setCarId(owner.getCarId());
	newOwner.setCreatedDate(owner.getCreatedDate());
	newOwner.setModifiedDate(owner.getModifiedDate());
	newOwner.setActive(owner.isActive());
	newOwner.setListOfCars(getCarList(owner.getCars()));
	return newOwner;
}

private static List<Car> getCarList(List<com.elsa.demo.springboot.database.entity.Car> carList){
	List<Car> newCarList = new ArrayList<Car>();
	for(com.elsa.demo.springboot.database.entity.Car car: carList ) {
		newCarList.add(toCarModel(car));
	}
	return newCarList;
}

}
