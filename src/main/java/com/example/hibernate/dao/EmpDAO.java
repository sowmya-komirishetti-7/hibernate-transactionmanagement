package com.example.hibernate.dao;

import com.example.hibernate.entity.Employee;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface EmpDAO {
	
	public void saveEmployee(Employee employee);
	
	public List<Employee> allEmployees();

}
