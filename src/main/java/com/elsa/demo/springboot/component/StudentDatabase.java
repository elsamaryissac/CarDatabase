package com.elsa.demo.springboot.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.elsa.demo.springboot.model.Student;

@Component
public class StudentDatabase {

	private List<Student> studentList;

	public List<Student> getStudentList() {
		return studentList;
	}
	
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	public void add(Student student) {
		if (this.studentList == null)
			this.studentList = new ArrayList<Student>();
		this.studentList.add(student);
	}

	@Override
	public String toString() {
		return "StudentDatabase [studentList=" + studentList + "]";
	}
}
