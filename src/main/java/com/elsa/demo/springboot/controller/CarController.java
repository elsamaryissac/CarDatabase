package com.elsa.demo.springboot.controller;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elsa.demo.springboot.component.CarDatabase;
import com.elsa.demo.springboot.model.Car;
import com.elsa.demo.springboot.model.Owner;
import com.elsa.demo.springboot.services.CarService;
import com.elsa.demo.springboot.services.OwnerService;

@RestController
@RequestMapping(value = "service/car", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CarController.class);
	
	@Autowired
	private CarService carService;
	@Autowired
	private OwnerService ownerService;
	
	@PostMapping("/add")
	public ResponseEntity<Car> add(@RequestBody Car car) {
		LOGGER.info("Car added to the database.");
		car.setModified("elsa");
		return new ResponseEntity<Car>(carService.addCar(car), HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Car> update(@RequestBody Car car) {
		LOGGER.info("Car updated in the database.");
		return new ResponseEntity<Car>(carService.updateCar(car), HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<Car> delete(@RequestBody Car car) {
		LOGGER.info("Car deleted from the database.");
		return new ResponseEntity<Car>(carService.disableCar(car), HttpStatus.OK);
	}
	
	@GetMapping("/getlist")
	public ResponseEntity<?> getList(){
		LOGGER.info("Get all the active cars.");
		//return new ResponseEntity<>("List is updated!", HttpStatus.OK);
		return new ResponseEntity<List<Car>>(carService.getActiveCarsList(), HttpStatus.OK);
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllCars(){
		LOGGER.info("Get all the cars!");
		//return new ResponseEntity<>("List is updated!", HttpStatus.OK);
		return new ResponseEntity<List<Car>>(carService.getCarList(), HttpStatus.OK);
		
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> get(@RequestParam Integer id){
		Car car = carService.get(id);
		LOGGER.info("Get Car by id");
		return new ResponseEntity<Car>(car, car==null?HttpStatus.NO_CONTENT: HttpStatus.OK);
		
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getbyid(@PathVariable(required=true) Integer id){
		Car car = carService.get(id);
		LOGGER.info("Get Car by id");
		return new ResponseEntity<Car>(car, car==null?HttpStatus.NO_CONTENT: HttpStatus.OK);
		
	}
	@GetMapping("/getbyname/{name}")
	public ResponseEntity<?> getbyname(@PathVariable(required=true) String name){
		List<Car> carList = carService.getByName(name);
		LOGGER.info("Get Car by id");
		return new ResponseEntity<List<Car>>(carList, carList==null?HttpStatus.NO_CONTENT: HttpStatus.OK);
		
	}
	
	@GetMapping("/getcompany")
	public ResponseEntity<?> get(@RequestParam String company){
		Car car = carService.get(company);
		car.setModified("Changed");
		LOGGER.info("Car Company available is : "+car.getName());
		return new ResponseEntity<Car>(car, car==null?HttpStatus.NO_CONTENT: HttpStatus.OK);
		
	}
	
	@GetMapping("/getbycompany/{company}")
	public ResponseEntity<?> getbycompany(@PathVariable(required=true) String company){
		Car car = carService.get(company);
		LOGGER.info("Car Company available is : "+car.getName());
		return new ResponseEntity<Car>(car, car==null?HttpStatus.NO_CONTENT: HttpStatus.OK);
	}
		
		@GetMapping("/getbycompanyandyear/{company}/{year}")
		public ResponseEntity<?> getbycompanyandyear(@PathVariable(required=true) String company,@PathVariable(required=true) Integer year){
			List<Car> carList = carService.getListByCompanyAndYear(company, year);
			//LOGGER.info("Car Company available is : "+car.getName());
			return new ResponseEntity<List<Car>>(carList, carList==null?HttpStatus.NO_CONTENT: HttpStatus.OK);
	}
		
		@GetMapping("/getbyenginepowerandyear/{enginePower}/{year}")
		public ResponseEntity<?> getbyenginepowerandyear(@PathVariable(required=true) Integer enginePower,@PathVariable(required=true) Integer year){
			List<Car> carList = carService.getListFilterEngPowAndYr(enginePower, year);
			//LOGGER.info("Car Company available is : "+car.getName());
			return new ResponseEntity<List<Car>>(carList, carList==null?HttpStatus.NO_CONTENT: HttpStatus.OK);
	}
		
		@PostMapping("/addowner")
		public ResponseEntity<Owner> add(@RequestBody Owner owner) {
			LOGGER.info("Owner added to the database.");
			return new ResponseEntity<Owner>(ownerService.addOwner(owner), HttpStatus.OK);
		}
		@GetMapping("/getallowners")
		public ResponseEntity<?> getAllOwners(){
			LOGGER.info("Get all the owners!");
			//return new ResponseEntity<>("List is updated!", HttpStatus.OK);
			return new ResponseEntity<List<Owner>>(ownerService.getOwnerList(), HttpStatus.OK);
			
		}
}
