package com.cap.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cap.entity.Employee;



@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	
	List<Employee> findByEname(String empName);
	@Query("select e.ename,e.esal from Employee e where e.esal=?1")
	Optional<Employee> findSalBt(@Param("c") Integer sal1);
	
	
	
}
	
