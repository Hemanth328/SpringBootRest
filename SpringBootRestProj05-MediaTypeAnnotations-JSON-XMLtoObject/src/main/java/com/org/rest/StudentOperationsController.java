package com.org.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Student;

@RestController
public class StudentOperationsController {

	@PostMapping("/register")
	public ResponseEntity<Student> registerStudent(@RequestBody Student stud) {
		
		System.out.println("StudentOperationsController.registerStudent()");
		
		return new ResponseEntity<Student>(stud, HttpStatus.CREATED);
	}
}
