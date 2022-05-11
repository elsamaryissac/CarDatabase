package com.elsa.demo.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@GetMapping("/Hello")
	public String getData() {
		return "Hello Elsa";
	}
}
