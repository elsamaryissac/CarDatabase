package com.elsa.demo.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elsa.demo.springboot.component.CarDatabase;
import com.elsa.demo.springboot.model.Car;

@RestController
@RequestMapping(value = "service/car", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {
	
	@Autowired
	private CarDatabase carDatabase;
	
	
	@PostMapping("/add")
	public ResponseEntity<Car> add(@RequestBody Car car) {
		car.setModified("elsa");
		carDatabase.add(car);
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> getList(){
		return new ResponseEntity<List<Car>>(carDatabase.getCarList(), HttpStatus.OK);
	}
}
