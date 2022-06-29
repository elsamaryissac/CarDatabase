package com.elsa.demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.elsa.demo.springboot.model.Owner;
import com.elsa.demo.springboot.services.OwnerService;

@RestController
@RequestMapping(value = "service/owner", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

public class OwnerController {
    @Autowired
	private OwnerService ownerService;
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getbyid(@PathVariable(required=true) Integer id){
		Owner owner = ownerService.getOwner(id);
		//LOGGER.info("Get Car by id");
		return new ResponseEntity<Owner>(owner, owner==null?HttpStatus.NO_CONTENT: HttpStatus.OK);
		
	}
}
