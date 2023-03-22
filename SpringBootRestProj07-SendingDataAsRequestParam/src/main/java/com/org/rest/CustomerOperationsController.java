package com.org.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PostExchange;

@RestController
@RequestMapping("/customercontro")
public class CustomerOperationsController {

	/*@GetMapping("/report")
	public ResponseEntity<String> showReport(@RequestParam("cno") int no, @RequestParam(required = false) String cname) {
		
		System.out.println("CustomerOperationsController.showReport()");
		
		System.out.println(no+"  "+cname);
		return new ResponseEntity<String>(no+" "+cname, HttpStatus.OK);
	} */
	
	
	
	@PostMapping("/report")
	public ResponseEntity<String> showReport(@RequestParam("cno") int no, @RequestParam(required = false) String cname) {
		
		System.out.println("CustomerOperationsController.showReport()");
		
		System.out.println(no+"  "+cname);
		return new ResponseEntity<String>(no+" "+cname, HttpStatus.OK);
	} 
}
