package com.org.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/api")
public class StudentOPerationsController {
	
	
	/*@GetMapping("/report/{sno}/{sname}")
	public ResponseEntity<String> showReport1(@PathVariable("sno") Integer no, @PathVariable String sname) {
		
		System.out.println("StudentOPerationsController.showReport1()");
		
		return new ResponseEntity<String>(no + "  " + sname, HttpStatus.OK);
		//http://localhost:8181/SpringBootRestProj08-SendingDataAsPathVariables/student/api/report/87965/Reyansh&1
	}*/
	
	
	/*@GetMapping("/report/{sno}/{sname}")
	public ResponseEntity<String> showReport1(@PathVariable(name = "sno", required = false) int no, @PathVariable String sname) {
		
		System.out.println("StudentOPerationsController.showReport1()");
		
		return new ResponseEntity<String>(no + "  " + sname, HttpStatus.OK);
		//http://localhost:8181/SpringBootRestProj08-SendingDataAsPathVariables/student/api/report/Reyansh&1 ==> this request will not be mapped with this get request as parameters are not matching 
	}*/
	
	
	/*@GetMapping("/report/{sno}/{sname}")
	public ResponseEntity<String> showReport1(@PathVariable("sno") String no, @PathVariable String sname) {
		
		System.out.println("StudentOPerationsController.showReport1()");
		
		return new ResponseEntity<String>(no + "  " + sname, HttpStatus.OK);
		//http://localhost:8181/SpringBootRestProj08-SendingDataAsPathVariables/student/api/report/87965/Reyansh&1
	}*/
	
	
	
	@GetMapping("/report/sno/{sname}")  // this will get high priority over the above method cause this mapping has static parameter due to which this method will be executed
	public ResponseEntity<String> showReport2(@PathVariable(name = "sno", required = false) Integer no, @PathVariable(required = false) String sname) {
		
		System.out.println("StudentOPerationsController.showReport2()");
		
		return new ResponseEntity<String>(no + "  " + sname, HttpStatus.OK);
		// http://localhost:8181/SpringBootRestProj08-SendingDataAsPathVariables/student/api/report/87965/Reyansh&1
	}
	
	
	
	@GetMapping("/report/{sno}/sname")
	public ResponseEntity<String> showReport3(@PathVariable(name ="sno", required= false) Integer no, @PathVariable(required = false) String sname) {
	
		System.out.println("StudentOPerationsController.showReport3()");
		
		return new ResponseEntity<String>(no + "  " + sname, HttpStatus.ACCEPTED);
	
	}
	
	
	
	@GetMapping("/report/sno/sname")
	public ResponseEntity<String> showReport4(@PathVariable(name = "sno", required = false) String no, @PathVariable(required = false) String sname) {
		
		System.out.println("StudentOPerationsController.showReport4()");
		
		return new ResponseEntity<String>(no+"  "+sname, HttpStatus.ACCEPTED);
		
	}
	
}
