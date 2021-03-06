package com.elsa.demo.springboot.model;

import java.util.Date;

public class Car {
	private String name;
	private String company;
	private Integer year;
	private Integer enginePower;
	private String modified;
	private Integer id;
	private Date createdDate;
	private Date modifiedDate;
	private boolean active;
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	
	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getEnginePower() {
		return enginePower;
	}

	public void setEnginePower(Integer enginePower) {
		this.enginePower = enginePower;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", company=" + company + ", year=" + year + ", enginePower=" + enginePower
				+ ", modified=" + modified + ", id=" + id + ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + ", active=" + active + "]";
	}


	

	

}
