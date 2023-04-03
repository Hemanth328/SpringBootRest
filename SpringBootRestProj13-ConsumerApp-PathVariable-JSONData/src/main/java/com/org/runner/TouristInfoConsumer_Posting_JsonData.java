package com.org.runner;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TouristInfoConsumer_Posting_JsonData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		//Creating the RestTemplate Object
		RestTemplate template = new RestTemplate();
		
		//Prepare Service URL + requestpath
		
		String serviceUrl = "http://localhost:8181/SpringBootRestProj13-ProviderApp-PathVariable-JSONData/wish/api/register";
		
		//prepare HttpHeaders
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON); //Optional to specify while sending JSON Data
		
		//prepare HttpRequest as HttpEntity having headers, Body
		String json_content = "{\"tid\":1001, \"tname\":\"Hemanth\",\"startPlace\":\"Hyderabad\", \"destPlace\":\"Vizag\" }";
		
		HttpEntity<String> request = new HttpEntity<String>(json_content,headers);
		
		//Send POST mode request to consume rest API Service
		ResponseEntity<String> response = template.postForEntity(serviceUrl, request, String.class);
		
		//Process the received Response
		System.out.println("Response Body : "+response.getBody());
		System.out.println("Response Status Code : "+response.getStatusCodeValue());
		System.out.println("Response Status Code : "+response.getStatusCode());
		System.out.println("Response Headers : "+response.getHeaders());
		
		System.out.println("==========================================");
		
		//send POST mode Request to consume rest api service
		String response1 = template.postForObject(serviceUrl, request, String.class);
		System.out.println("Response Content/Body : "+response1);
		
	}

}
