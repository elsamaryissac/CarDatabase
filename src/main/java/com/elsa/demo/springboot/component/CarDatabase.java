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

	public Car get(Integer id) {
     Car car = null;
     if(getCarList() != null) {
    	car = getCarList()
    			.stream()
    			.filter(c->c.getId() == id)
    			.findFirst()
    			.orElse(null);
    	
    	/*for(Car c: getCarList()) {
    		if(c.getId() == id) {
    			car = c;
    		}
    	}*/
    	
     }
     return car;
     
    
	}

	public Car get(String company) {
	     Car car = null;
	     if(getCarList() != null) {
	    	car = getCarList()
	    			.stream()
	    			.filter(c->c.getCompany().equals(company))
	    			.findFirst()
	    			.orElse(null);
	    	
	    	/*for(Car c: getCarList()) {
	    		if(c.getId() == id) {
	    			car = c;
	    		}
	    	}*/
	    	
	     }
	     return car;
	     
	    
		}
	@Override
	public String toString() {
		return "CarDatabase [carList=" + carList + "]";
	}
}
