package com.org.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WishMessageConsumerRunner implements CommandLineRunner{

	
	@Autowired
	private RestTemplate template;
	
	@Value("${service.url}")
	private String serviceUrl;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		// Consume the service using xxxForEntity(-) method
		ResponseEntity<String> response = template.getForEntity(serviceUrl, String.class);
		
		//process response
		System.out.println("Response body/payload (output) : "+response.getBody());
		System.out.println("Response status code value : "+response.getStatusCodeValue());
		System.out.println("Response Code : "+response.getStatusCode());
		System.out.println("Response Headers ");
	}
}
