package com.example.hibernate.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.hibernate.entity.Employee;

import org.hibernate.SessionFactory;

@Repository
public class EmployeeDAO implements EmpDAO{
	
	
	private SessionFactory sessionFactory;

	@Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public void saveEmployee(Employee employee) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(employee);
        tx.commit();
        session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> allEmployees(){
		
		Session session = this.sessionFactory.openSession();
		List<Employee> employeeList = session.createQuery("FROM Employee").list();
		session.close();
		return employeeList;
	}
}
