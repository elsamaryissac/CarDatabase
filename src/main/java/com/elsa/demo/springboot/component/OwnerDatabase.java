package com.elsa.demo.springboot.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.elsa.demo.springboot.model.Owner;
@Component
public class OwnerDatabase {
private List<Owner> ownerList;
	
	public List<Owner> getOwnerList() {
		return ownerList;
	}

	public void setOwnerList(List<Owner> OwnerList) {
		this.ownerList = ownerList;
	}

	public void add(Owner owner) {
		if (this.ownerList == null)
			this.ownerList = new ArrayList<Owner>();
		this.ownerList.add(owner);
	}
}
