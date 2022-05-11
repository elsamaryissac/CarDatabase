package com.elsa.demo.springboot.model;

public class Student {
	private String name;
	private String gender;
	private Integer dob;

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

	public Integer getDob() {
		return dob;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + ", dob=" + dob + "]";
	}

	public void setDob(Integer dob) {
		this.dob = dob;
	}

}
