package com.org.runner;

import java.util.Map;

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
		String serviceUrl = "http://localhost:8181/SpringBootRestProj13-ProviderApp-PathVariable-JSONData/wish/api/message/{id}/{name}";
		
		// Consume the service using xxxForEntity(-) method
		ResponseEntity<String> response = template.getForEntity(serviceUrl, String.class,Map.of("name","Hemanth","id",8762)); // Map obj to pass path variable values, we need not to follow the order
		
		//process response
		System.out.println("Response body/payload (output) : "+response.getBody());
		System.out.println("Response status code value : "+response.getStatusCodeValue());
		System.out.println("Response Code : "+response.getStatusCode());
		System.out.println("Response Headers ");
		System.out.println();
		System.out.println("====================================");
		
		String response1 = template.getForObject(serviceUrl, String.class,3656,"Reyansh"); //Var args to pass path variable values, we need to follow the order
		System.out.println("Response Content : "+response1); // gives only response body
	}
}
