package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private SessionFactory factory;

	@Override
	public List<Customer> getCustomers() {
		Session currentSession = factory.getCurrentSession();
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer", Customer.class);
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

}
