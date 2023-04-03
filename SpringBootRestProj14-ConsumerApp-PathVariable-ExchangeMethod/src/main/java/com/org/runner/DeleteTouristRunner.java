package com.org.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DeleteTouristRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		//create a RestTemplate
		RestTemplate template = new RestTemplate();
		
		//preparer service url
		
		//Prepare Service URL + requestpath
		String serviceUrl = "http://localhost:8181/SpringBootRestProj14-ProviderApp-PathVariable-ExchangeMethod/wish/api/delete/{id}";
		
		//send delete mode request
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.DELETE, null, String.class, 65);
		
		System.out.println();
		System.out.println("Delete Operation is completed");
		
		//Process received response
		System.out.println("Response Body : "+response.getBody());
		System.out.println("Response status value : "+response.getStatusCodeValue());
		System.out.println("Response status code : "+response.getStatusCode());
		System.out.println("Response Headers : "+response.getHeaders());
		
		System.out.println("==============================================");
		

	}

}
