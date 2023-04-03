package com.org.rest;

import org.springframework.http.HttpStatus;import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Tourist;

@RestController
@RequestMapping("/wish/api")
public class WishMessageController {

	@GetMapping("/message/{id}/{name}")
	public ResponseEntity <String> showWishMesaage(@PathVariable("id") int id, @PathVariable("name") String name) {
		
		System.out.println("Id : "+id+"  name : "+name);
		return new ResponseEntity<String>("Good Morning "+id+" "+name, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist) {
		
		System.out.println("WishMessageController.registerTourist() "+tourist);
		return new ResponseEntity<String>("Tourist Info "+tourist.toString(), HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteTourist(@PathVariable("id") int id) {
		return new ResponseEntity<String>("Tourister with Id "+id+" deleted", HttpStatus.ACCEPTED);
	}
}
