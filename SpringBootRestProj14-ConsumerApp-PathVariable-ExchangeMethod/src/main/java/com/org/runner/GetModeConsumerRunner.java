package com.org.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GetModeConsumerRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		//Create a RestTemplate class obj
		RestTemplate template = new RestTemplate();
		
		//prepare a ServiceUrl (or) BaseUrl + requestPath
		String serviceUrl = "http://localhost:8181/SpringBootRestProj14-ProviderApp-PathVariable-ExchangeMethod/wish/api/report";;
		
		//invoke the exchange(---) method
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.GET, null, String.class);
		
		System.out.println("Response Body : "+response.getBody());
		System.out.println("Response status value : "+response.getStatusCodeValue());
		System.out.println("Response status code : "+response.getStatusCode());
		System.out.println("Response Headers : "+response.getHeaders());
		
		System.out.println("==============================================");

		
		String serviceUrl1 = "http://localhost:8181/SpringBootRestProj14-ProviderApp-PathVariable-ExchangeMethod/wish/api/message/{id}/{name}";;
		
		//invoke the exchange(---) method
		ResponseEntity<String> response1 = template.exchange(serviceUrl1, HttpMethod.GET, null, String.class, Map.of("id",85,"name","Niharika"));
		
		System.out.println("Response Body : "+response1.getBody());
		System.out.println("Response status value : "+response1.getStatusCodeValue());
		System.out.println("Response status code : "+response1.getStatusCode());
		System.out.println("Response Headers : "+response1.getHeaders());
		
		System.out.println("==============================================");

	}

}
