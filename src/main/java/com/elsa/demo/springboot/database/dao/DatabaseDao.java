package com.elsa.demo.springboot.database.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.elsa.demo.springboot.database.entity.Car;

@Component
public class DatabaseDao {

//	private static final String PERSISTENCE_UNIT_NAME = "Employee";
//	EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

	@PersistenceContext
	private EntityManager entityManager;

	public List<Car> getListByCompanyAndYear(String company, Integer year) {
		Query jpqlQuery = entityManager.createQuery("FROM Car c WHERE c.company=:company AND c.year=:year");
	    jpqlQuery.setParameter("company", company);
	    jpqlQuery.setParameter("year", year);
	    System.out.println(company + year);
	    System.out.println(jpqlQuery.getResultList());
	    return (List<Car>)jpqlQuery.getResultList();
		
	}
	
	public List<Car> getListByEngPowGreaterThan1000AndYr(Integer enginePower, Integer year){
		Query jpqlQuery = entityManager.createQuery("FROM Car c WHERE c.enginePower >: enginePower AND c.year=:year");
		jpqlQuery.setParameter("enginePower", enginePower);
	    jpqlQuery.setParameter("year", year);
	    System.out.println(enginePower);
	    System.out.println(jpqlQuery.getResultList());
	    return (List<Car>)jpqlQuery.getResultList();
		
	}
}
