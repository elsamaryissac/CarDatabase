package com.elsa.demo.springboot.model;

import java.util.Date;

public class Car {
	private String name;
	private String company;
	private Integer year;
	private String modified;
	private Integer id;
	private Date createdDate;
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

	private Date modifiedDate;
	
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
		return "Car [name=" + name + ", company=" + company + ", year=" + year + ", modified=" + modified + ", id=" + id
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + "]";
	}

	

	

}
