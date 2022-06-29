package com.elsa.demo.springboot.model;

import java.util.Date;
import java.util.List;

import javax.persistence.OneToMany;

public class Owner {

	private String name;
	private String gender;
	private Integer age;
	private Integer carId;
	private String modifiedBy;
	private Integer id;
	private Date createdDate;
	private Date modifiedDate;
	private boolean active;
	
	
	private List<Car> listOfCars;
	
	public List<Car> getListOfCars() {
		return listOfCars;
	}

	public void setListOfCars(List<Car> listOfCars) {
		this.listOfCars = listOfCars;
	}
	
	
	@Override
	public String toString() {
		return "Owner [name=" + name + ", gender=" + gender + ", age=" + age + ", carId=" + carId + ", modifiedBy="
				+ modifiedBy + ", id=" + id + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
				+ ", active=" + active + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
