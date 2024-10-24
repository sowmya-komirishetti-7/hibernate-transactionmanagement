package com.example.hibernate;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.example.hibernate.dao.EmpDAO;
import com.example.hibernate.dao.EmployeeDAO;
import com.example.hibernate.entity.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class TransactionManagementWithHibernateApplication {
	
	public static void main(String[] args) {
	
	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:hibernate.cfg.xml");
		EmployeeDAO empDAO = context.getBean(EmployeeDAO.class);
		
		Employee emp = new Employee();
		
		emp.setName("Sowmya");
		emp.setPosition("Tester");
		emp.setSalary(25000);
		
		empDAO.saveEmployee(emp);
		System.out.println("Employee Successfully Saved!");
		
		
		
			List<Employee> list = empDAO.allEmployees();
		    for(Employee e : list) {
		    	System.out.println("Employee List::" + e);
		    }
		    context.close();
	
	}

}
