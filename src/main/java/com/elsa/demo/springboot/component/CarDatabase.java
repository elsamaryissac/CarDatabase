package com.elsa.demo.springboot.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.elsa.demo.springboot.model.Car;

@Component
public class CarDatabase {
private List<Car> carList;

public List<Car> getCarList() {
	return carList;
}

public void setCarList(List<Car> carList) {
	this.carList = carList;
}

public void add(Car car) {
	if (this.carList == null)
		this.carList = new ArrayList<Car>();
	this.carList.add(car);
}

@Override
public String toString() {
	return "CarDatabase [carList=" + carList + "]";
}
}
