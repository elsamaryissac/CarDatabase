package com.elsa.demo.springboot.services.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsa.demo.springboot.component.CarDatabase;
import com.elsa.demo.springboot.database.common.ModelTransformer;
import com.elsa.demo.springboot.database.dao.DatabaseDao;
import com.elsa.demo.springboot.database.repository.CarRepository;
import com.elsa.demo.springboot.model.Car;
import com.elsa.demo.springboot.services.CarService;

@Service
public class CarServiceImpl implements CarService {
//    @Autowired
//	private CarDatabase carDatabase;
    @Autowired 
    private CarRepository carRepository;
    @Autowired
    private DatabaseDao databaseDao;
    
	@Override
	public Car addCar(Car car) {
		car.setCreatedDate(new Date());
		car.setModifiedDate(new Date());
		car.setActive(true);
		com.elsa.demo.springboot.database.entity.Car carEntity = carRepository.save(mapCarToEntity(car));
		return mapCar(carEntity);
	}

	@Override
	public List<Car> getCarList() {
		System.out.println(carRepository.findAll());
		return getCarList((List<com.elsa.demo.springboot.database.entity.Car>) carRepository.findAll());
		
	}
	
	@Override
	public List<Car> getActiveCarsList() {
		return getCarList().stream().filter(c->c.isActive()).collect(Collectors.toList());
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
		return mapCar(findCarEntity(id));
		
	}
	
	private com.elsa.demo.springboot.database.entity.Car findCarEntity(Integer id){
		return carRepository.findById(id).orElse(null);
	}
	
//	public Car get(String company) {
//		return carDatabase.get(company);
//		
//	}

	@Override
	public Car updateCar(Car car) {
		com.elsa.demo.springboot.database.entity.Car selectedCar=findCarEntity(car.getId());
		if(selectedCar == null) {
			return null;
		}
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
		carRepository.save(selectedCar);
		return mapCar(selectedCar);
	}

	@Override
	public Car deleteCar(Car car) {
//		Car carToBeDeleted=get(car.getId());
//			carDatabase.delete(carToBeDeleted);
//			carDatabase.updateCarList();
		return car;
	}
	
	@Override
	public Car disableCar(Car car) {
		com.elsa.demo.springboot.database.entity.Car selectedCar=findCarEntity(car.getId());
		if(selectedCar == null) {
			return null;
		}
		selectedCar.setModifiedDate(new Date());
		selectedCar.setActive(false);
		carRepository.save(selectedCar);
		return mapCar(selectedCar);
	}
	
	private List<Car> getCarList(List<com.elsa.demo.springboot.database.entity.Car> carList){
		if(carList!= null && !carList.isEmpty()) {
			return carList.stream().map(car->mapCar(car)).collect(Collectors.toList());
			
		}
		return null;
	}
	
	private Car mapCar(com.elsa.demo.springboot.database.entity.Car car) {
		return ModelTransformer.toCarModel(car);
	}
	
	private com.elsa.demo.springboot.database.entity.Car mapCarToEntity(Car car) {
		return ModelTransformer.toCarEntity(car);
		
	}

	@Override
	public Car get(String company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> getByName(String name) {
		return getCarList((List<com.elsa.demo.springboot.database.entity.Car>) carRepository.findByName(name));
	}

	@Override
	public List<Car> getListByCompanyAndYear(String company, Integer year) {
		return getCarList((List<com.elsa.demo.springboot.database.entity.Car>) databaseDao.getListByCompanyAndYear(company,year));
		
	}

	@Override
	public List<Car> getListByEngPowGreaterThan1000AndYr(Integer enginePower, Integer year) {
		return getCarList((List<com.elsa.demo.springboot.database.entity.Car>) databaseDao.getListByEngPowGreaterThan1000AndYr(enginePower, year));
		//return getCarList((List<com.elsa.demo.springboot.database.entity.Car>) carRepository.findByEnginePowerGreaterThan(enginePower, year));
	}
	
	
}
