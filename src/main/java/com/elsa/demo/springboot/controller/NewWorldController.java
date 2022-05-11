package com.elsa.demo.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewWorldController {
@GetMapping("/NewWorld")
public String getData() {
	return "New World 2022";
}
}


