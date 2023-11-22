package com.org.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.model.Politician;


/*
 * Only this Runner class will execute cause in other Runner classes the ServiceURL is commented due to which the consumer application
 * will raise error(this application after executing this Runner class)
 */

@Component
public class JSONDataConvertorRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		//prepare ServiceUrl
		
		String ServiceUrl = "http://localhost:8181/SpringBootRestProj15-ProviderApp-JSONObject/politician/api/find/{id}";
		
		// Invoke the Rest APi/ Provider Service
		ResponseEntity<String> response = template.exchange(ServiceUrl, HttpMethod.GET, null, String.class, 8954);
		
		// Analyze the Response
		System.out.println("Response Content/Body : "+response.getBody());
		System.out.println("Response status code : "+response.getStatusCode()+"  "+response.getStatusCodeValue());
		System.out.println("Response Headers : "+response.getHeaders());
		
		
		// convert the received json response content into Java Class Object using Jsckson API (Desrialization)
		ObjectMapper mapper = new ObjectMapper();
		
		Politician politician = mapper.readValue(response.getBody(), Politician.class);
		
		politician.setRetirementAge(politician.getAge()+20);
		
		System.out.println("Json to Object Convertion Data : "+politician);
		
	}
}
