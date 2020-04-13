package com.cap.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.entity.Employee;
import com.cap.service.EmployeeService;
import com.cap.exceptions.RecordNotFoundException;

@RestController
@RequestMapping("/Emp")
@CrossOrigin("http://localhost:9098")//
public class RestControllerEmp{

	@Autowired
	private EmployeeService empService;
	@PostMapping("/CreateAccount")
	public String createAccount(@RequestBody Employee emp) {
		return empService.createEmployee(emp);
	}
	@GetMapping("/findById/{empId}")
	public Optional<Employee> findEmployee(@PathVariable Integer empId) {
		return empService.findEmployee(empId);
	}
	@GetMapping("/findAll")
	public List<Employee> findAllEmployees() {
		return empService.findAllEmployees();
	}
	@GetMapping("/fetchSal/{sal1}")
	public Optional<Employee> fetchSalBt(@PathVariable int sal1) {
		return empService.fetchSalBt(sal1);	
	}

	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Record not found with this details")
	@GetMapping(path="/findByName/{empName}")
	public List<Employee> findEmployeeByName(@PathVariable String empName) {
		List<Employee> employee=empService.findEmpByName(empName);
		if(employee == null) {
	         throw new RecordNotFoundException("Invalid employee Name : " + empName);
	    }
		return employee;
	
	}
	@PutMapping("/updateEmp")
	public String updateEmp(@RequestBody Employee emp) {
		return empService.updateEmployee(emp);
	}
	@DeleteMapping("/deleteEmp/{empId}")
	public String deleteEmp(@PathVariable Integer empId) {
		String employee= empService.deleteEmpById(empId);
		if(employee==null) {
			throw new RecordNotFoundException("cannot delete : " + empId);
		}
		return employee;
	}
}
