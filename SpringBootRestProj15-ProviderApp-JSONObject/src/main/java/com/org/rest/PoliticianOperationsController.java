package com.org.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Address;
import com.org.model.Politician;

@RestController
@RequestMapping("/politician/api")
public class PoliticianOperationsController {

	/*
	
	// Use this when there is no Address property in Politician entity
	 
	@GetMapping("/find/{id}")
	public ResponseEntity<Politician> findPoliticianById(@PathVariable("id") int id) {
		return new ResponseEntity<Politician>(new Politician(id, "JayShankar", "BJP", "EAM", 60.0f), HttpStatus.OK);
	}
	
	*/
	@GetMapping("/find/{id}")
	public ResponseEntity<Politician> findPoliticianById(@PathVariable("id") int id) {
		return new ResponseEntity<Politician>(new Politician(id, "JayShankar", "BJP", "EAM", 60.0f, new Address("1/69", "Minister street", 123456L)), HttpStatus.OK);
	}
	
	
	/*
	 
	// Use this when there is no Address property in Politician entity
	
	@GetMapping("/report")
	public ResponseEntity<List<Politician>> showAllPoliticians() {
		List<Politician> list = List.of(new Politician(8976, "JayShankar", "BJP", "EAM", 60.0f),
				                        new Politician(9712, "Modi", "BJP", "PM", 67.0f),
				                        new Politician(7462, "NitinGadkari", "BJP", "RT&HM", 66.0f));
		
		return new ResponseEntity<List<Politician>>(list, HttpStatus.ACCEPTED);
	}
	*/
	
	@GetMapping("/report1")
	public ResponseEntity<Map<String, Object>> showIdCards() {
		Map<String, Object> map = Map.of("aadhar", "123456", "voterId", "ABS87964", "pancard", "ASDC7465KL");
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.CREATED);
	}
	
	
}
