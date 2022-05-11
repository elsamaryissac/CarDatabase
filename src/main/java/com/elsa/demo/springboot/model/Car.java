package com.elsa.demo.springboot.model;

public class Car {
	private String name;
	private String company;
	private Integer year;
	private String modified;
	
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

	@Override
	public String toString() {
		return "Car [name=" + name + ", company=" + company + ", year=" + year + ", modified=" + modified + "]";
	}

	

}
