package com.elsa.demo.springboot.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsa.demo.springboot.component.OwnerDatabase;
import com.elsa.demo.springboot.database.common.ModelTransformer;
import com.elsa.demo.springboot.database.repository.OwnerRepository;
import com.elsa.demo.springboot.model.Owner;
import com.elsa.demo.springboot.services.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService {

	 @Autowired
private OwnerDatabase ownerDatabase;
	 @Autowired
	 private OwnerRepository ownerRepository;
	 
	@Override
	public Owner addOwner(Owner owner) {
		owner.setCreatedDate(new Date());
		owner.setModifiedDate(new Date());
		owner.setActive(true);
		ownerDatabase.add(owner);
		return owner;
		
	}

	@Override
	public List<Owner> getOwnerList() {
		
		return ownerDatabase.getOwnerList();
	}

	@Override
	public Owner getOwner(Integer id) {
		return ModelTransformer.toOwnerModel(ownerRepository.findById(id).orElse(null));
	}

}
