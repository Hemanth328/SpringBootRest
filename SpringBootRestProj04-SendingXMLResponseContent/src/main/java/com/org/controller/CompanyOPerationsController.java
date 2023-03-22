package com.org.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Company;

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
	
	
	@GetMapping("/details1")
	public ResponseEntity<Company> showCompanyDeatils1() {
		
		Company company = new Company("Aboves.Ltd", "Vizag", 5430, 54686400.00, "IT");
		
		return new ResponseEntity<Company>(company, HttpStatus.OK);
		
		
		// Allows us to take our choice response status code like HTTPStaus.OK, HTTPSatus.CREATED and etc 
		// because the ResposnseEntity object can hold multiple details including response body/content and status code
	}
}
