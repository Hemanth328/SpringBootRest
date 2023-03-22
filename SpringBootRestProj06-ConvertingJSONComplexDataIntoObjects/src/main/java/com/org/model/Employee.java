package com.org.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class Employee {
	
	private Integer empNo;
	private String empName;
	private Address empAddress; // HAS-A property 2D array
	private String[] favColors;  // 1D array
	private List<String> nickNames;  // 1D array
	private Set<Long> phoneNumbers; // 1D array
	private Map<String, Long> idDetails;  //2D array
}
