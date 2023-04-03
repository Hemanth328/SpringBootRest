package com.org.model;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
import lombok.Data;

//@Entity
@Data
public class Tourist {

//	@Id
//	@GeneratedValue
	private int tid;
	private String tname;
	private String startPlace;
	private String destPlace;
}
