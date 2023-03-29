package com.org.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WishMessageConsumerRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		
		//create RestTemplate class obj
		RestTemplate template = new RestTemplate();
		
		//prepare service based url
		String serviceUrl = "http://localhost:8181/SpringBootRestProj12-ProviderApp/wish/api/message";
		
		// Consume the service using xxxForEntity(-) method
		ResponseEntity<String> response = template.getForEntity(serviceUrl, String.class);
		
		//process response
		System.out.println("Response body/payload (output) : "+response.getBody());
		System.out.println("Response status code value : "+response.getStatusCodeValue());
		System.out.println("Response Code : "+response.getStatusCode());
		System.out.println("Response Headers ");
		System.out.println();
		System.out.println("====================================");
		
		String response1 = template.getForObject(serviceUrl, String.class);
		System.out.println("Response Content : "+response1); // gives only response body
	}
}
