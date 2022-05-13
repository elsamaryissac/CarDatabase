package com.elsa.demo.springboot.controller;

import java.util.List;

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

import com.elsa.demo.springboot.model.Car;
import com.elsa.demo.springboot.services.CarService;

@RestController
@RequestMapping(value = "service/car", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@PostMapping("/add")
	public ResponseEntity<Car> add(@RequestBody Car car) {
		car.setModified("elsa");
		return new ResponseEntity<Car>(carService.addCar(car), HttpStatus.OK);
	}
	
	@GetMapping("/getlist")
	public ResponseEntity<?> getList(){
		carService.getCarList();
		//return new ResponseEntity<>("List is updated!", HttpStatus.OK);
		return new ResponseEntity<List<Car>>(carService.getCarList(), HttpStatus.OK);
		
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> get(@RequestParam Integer id){
		Car car = carService.get(id);
		//return new ResponseEntity<>("List is updated!", HttpStatus.OK);
		return new ResponseEntity<Car>(car, car==null?HttpStatus.NO_CONTENT: HttpStatus.OK);
		
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getbyid(@PathVariable(required=true) Integer id){
		Car car = carService.get(id);
		//return new ResponseEntity<>("List is updated!", HttpStatus.OK);
		return new ResponseEntity<Car>(car, car==null?HttpStatus.NO_CONTENT: HttpStatus.OK);
		
	}
	
	@GetMapping("/getcompany")
	public ResponseEntity<?> get(@RequestParam String company){
		Car car = carService.get(company);
		return new ResponseEntity<Car>(car, car==null?HttpStatus.NO_CONTENT: HttpStatus.OK);
		
	}
	
	@GetMapping("/getbycompany/{company}")
	public ResponseEntity<?> getbycompany(@PathVariable(required=true) String company){
		Car car = carService.get(company);
		//return new ResponseEntity<>("List is updated!", HttpStatus.OK);
		return new ResponseEntity<Car>(car, car==null?HttpStatus.NO_CONTENT: HttpStatus.OK);
		
	}
	
}
