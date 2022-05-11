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

import com.elsa.demo.springboot.component.StudentDatabase;
import com.elsa.demo.springboot.model.Student;

@RestController
@RequestMapping(value="registration/student", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

	@Autowired
	private StudentDatabase studentDatabase;
	
	@PostMapping("/add")
	public ResponseEntity<Student> add(@RequestBody Student student) {
		studentDatabase.add(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> getList(){
		return new ResponseEntity<List<Student>>(studentDatabase.getStudentList(), HttpStatus.OK);
	}
}
