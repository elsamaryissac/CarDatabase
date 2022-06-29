package com.elsa.demo.springboot.services;

import java.util.List;

import com.elsa.demo.springboot.model.Owner;

public interface OwnerService {

	public Owner addOwner(Owner owner);
	public List<Owner> getOwnerList();
	public Owner getOwner(Integer id);
}
