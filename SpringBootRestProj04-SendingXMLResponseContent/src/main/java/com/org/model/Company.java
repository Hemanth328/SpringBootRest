package com.org.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Company {
	
	private String name;
	private String location;
	private Integer size;
	private Double turnOver;
	private String category;

}
