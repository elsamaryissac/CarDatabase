package com.elsa.demo.springboot.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.elsa.demo.springboot.model.Car;
import com.elsa.demo.springboot.services.CarService;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class CarControllerTest {

	@InjectMocks
    CarController carController;
    
	@Mock
	CarService carService;
	
	/*
	 * @PostMapping("/add")
		public ResponseEntity<Car> add(@RequestBody Car car) {
		LOGGER.info("Car added to the database.");
		car.setModified("elsa");
		return new ResponseEntity<Car>(carService.addCar(car), HttpStatus.OK);
	}
	
	 */
	
	@Test
	public void testAddCar() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        Car car = new Car();
        car.setName("Nano");
        when(carService.addCar((Car) org.mockito.ArgumentMatchers.any(Car.class))).thenReturn(car);
        
        ResponseEntity<Car> responseEntity = carController.add(car);
        
        assertTrue(responseEntity.getStatusCodeValue()==200);
        
	}
	
	@Test
	public void testUpdateCar() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        Car car = new Car();
        car.setName("dzire");
        when(carService.updateCar(org.mockito.ArgumentMatchers.any(Car.class))).thenReturn(car);
        
        ResponseEntity<Car> responseEntity = carController.update(car);
     
        assertTrue(responseEntity.getStatusCodeValue()==200);
        
	}
	
	@Test
	public void testUpdateNewCar() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        Car car = new Car();
        
        car.setName("liva");
        when(carService.updateCar(org.mockito.ArgumentMatchers.any(Car.class))).thenReturn(car);
        
        ResponseEntity<Car> responseEntity = carController.update(car);
     
        assertTrue(responseEntity.getStatusCodeValue()==200);
        
	}
}
