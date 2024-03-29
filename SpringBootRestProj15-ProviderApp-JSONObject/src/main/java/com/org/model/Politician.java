package com.org.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Politician {

	private int pid;
	private String pname;
	private String party;
	private String position;
	private float age;
	
	// HAS-A Property
	private Address addrs;
}
