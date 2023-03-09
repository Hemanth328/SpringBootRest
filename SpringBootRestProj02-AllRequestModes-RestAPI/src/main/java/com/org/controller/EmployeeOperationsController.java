package com.org.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

@RestController
@RequestMapping("/employee/api")
public class EmployeeOperationsController {

	@GetMapping("/all")
	public ResponseEntity<String> getAllEmployees() {
		System.out.println("EmployeeOperationsController.getAllEmployees()");
		return new ResponseEntity<String>("GET Mapping -- Fetching all the Employees", HttpStatus.OK);
	}
	
	
	
	@PostMapping("/save")
	public ResponseEntity<String> registerEmployee() {
		System.out.println("EmployeeOperationsController.registerEmployee()");
		return new ResponseEntity<String>("POST Mapping -- Saving the Employee", HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee() {
		System.out.println("EmployeeOperationsController.updateEmployee()");
		return new ResponseEntity<String>("PUT Mapping -- Updating all the Employees", HttpStatus.ACCEPTED);
	}
	
	
	
	@PatchMapping("/updateEmail")
	public ResponseEntity<String> updateEmployeeEmail() {
		System.out.println("EmployeeOperationsController.updateEmployeeEmail()");
		return new ResponseEntity<String>("PATCH Mapping -- Updating the employee partial", HttpStatus.PARTIAL_CONTENT);
	}
	
	
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmployees() {
		System.out.println("EmployeeOperationsController.deleteEmployees()");
		return new ResponseEntity<String>("DELETE Mapping -- Deleting the employee", HttpStatus.OK);
	}
	
	
	
}
