package com.cap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cap.entity.Employee;



public interface EmpServiceImpl {
	String createEmployee(Employee emp);

	Optional<Employee> findEmployee(Integer empId);

	List<Employee> findAllEmployees();

	List<Employee> findEmpByName(String empName);

	String updateEmployee(Employee emp);

	String deleteEmpById(Integer eId);

	Optional<Employee> fetchSalBt(Integer sal1);


}
