package com.org.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Company;
import com.org.model.Employee;

@RestController
@RequestMapping("/company")
public class CompanyOPerationsController {

	@GetMapping("/details")
	public ResponseEntity<Company> showCompanyDeatils() {
		
		Company company = new Company("Aboves.Ltd", "Vizag", 5430, 54686400.00, "IT");
	
		return new ResponseEntity<Company>(company, HttpStatus.OK);
	
	
		// Allows us to take our choice response status code like HTTPStaus.OK, HTTPSatus.CREATED and etc 
		// because the ResposnseEntity object can hold multiple details including response body/content and status code
	}
	                            
	
	/*@GetMapping("/details")
	public Company showCompanyDeatils() {
		
		Company company = new Company("Aboves.Ltd", "Vizag", 5430, 54686400.00, "IT");
		
		return company;
		
		// In RestAPI we can take direct return type like String, model Class, Object but it is not recommended to take
	}*/
	
	@GetMapping("/show")
	public ResponseEntity<Employee> showCompanyDetails() {
		
		Company company = new Company("VMWare", "Hyderabad", 5600, 9865164000.00, "IT");
		
		Employee emp = new Employee(112264,
				                    "Hemanth Kumar", 
				                    new String[] {"red", "green", "blue", "red"},
				                    List.of("KLRahul", "Dravid", "Sehwag", "Gilchrist"),
				                    Set.of(999999999L, 8888888L, 777777777L, 66666666L, 55555555L),
				                    Map.of("Aadhar", 1234567890L, "VoterId", 98746652L),
				                    true,
				                    LocalDateTime.of(1976, 8, 25, 06, 36), 
				                    company);
		
		// create and Return ResponseEntity obj having model class obj as the response body/content
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
}
