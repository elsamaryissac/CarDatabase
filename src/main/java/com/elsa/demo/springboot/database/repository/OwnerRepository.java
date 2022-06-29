package com.elsa.demo.springboot.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elsa.demo.springboot.database.entity.Owner;


public interface OwnerRepository extends JpaRepository<Owner, Integer>{

}
