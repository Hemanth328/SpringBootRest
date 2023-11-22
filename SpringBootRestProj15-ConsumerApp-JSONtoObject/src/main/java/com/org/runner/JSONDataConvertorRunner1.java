package com.org.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.model.Politician;

@Component
public class JSONDataConvertorRunner1 implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		//prepare ServiceUrl
		
		String ServiceUrl = "http://localhost:8181/SpringBootRestProj15-ProviderApp-JSONObject/politician/api/report";
		
		// Invoke the Rest APi/ Provider Service
		ResponseEntity<String> response = template.exchange(ServiceUrl, HttpMethod.GET, null, String.class);
		
		// Analyze the Response
		System.out.println("Response Content/Body : "+response.getBody());
		System.out.println("Response status code : "+response.getStatusCode()+"  "+response.getStatusCodeValue());
		System.out.println("Response Headers : "+response.getHeaders());
		
		// convert the received json response content into Java Class Object using Jsckson API (Desrialization)
		ObjectMapper mapper = new ObjectMapper();
		
		Politician politicians[] = mapper.readValue(response.getBody(), Politician[].class);
		
		List<Politician> list = Arrays.asList(politicians);
		list.forEach(System.out::println);
		
		System.out.println("==========================================================");
		
		List<Politician> list1 = mapper.readValue(response.getBody(), new TypeReference<List<Politician>>() {});
		list1.forEach(System.out::println);
		
	}
}
