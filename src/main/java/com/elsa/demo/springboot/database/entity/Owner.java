package com.elsa.demo.springboot.database.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.elsa.demo.springboot.database.entity.Car;

@Entity
@Table
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String name;
	@Column
	private String gender;
	@Column
	private Integer age;
	@Column(name="carid")
	private Integer carId;
	@Column
	private String modifiedBy;
	@Column(name="createddate")
	private Date createdDate;
	@Column(name="modifieddate")
	private Date modifiedDate;
	@Column
	private boolean active;
	
	@JoinColumn(name = "FK_carId",nullable = false)
	@OneToMany(targetEntity=Car.class)
	private List<Car> cars;
	
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> listOfCars) {
		this.cars = listOfCars;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
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
	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", carId=" + carId
				+ ", modifiedBy=" + modifiedBy + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
				+ ", active=" + active + "]";
	}
	
}
