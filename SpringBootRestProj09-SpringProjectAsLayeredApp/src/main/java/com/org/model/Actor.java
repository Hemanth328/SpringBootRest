package com.org.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="REST_ACTOR")
public class Actor {
	
	@Id
	@GeneratedValue
	private Integer actorId;
	@Column(length = 50)
	private String actorName;
	@Column(length = 40)
	private String category;
	private Long mobileNo;

}
