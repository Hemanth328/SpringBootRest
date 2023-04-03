package com.org.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
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
		
		String serviceUrl = "http://localhost:8181/SpringBootRestProj13-ProviderApp-PathVariable-JSONData/wish/api/delete/{id}";
		
		//send delete mode Request
		template.delete(serviceUrl, Map.of("id", 54)); // delete method has no return type
		
		System.out.println("Delete Operation is completed");
		

	}

}
