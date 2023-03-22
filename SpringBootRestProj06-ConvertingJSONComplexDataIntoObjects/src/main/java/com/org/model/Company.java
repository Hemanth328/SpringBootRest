package com.org.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Company {

	private Long companyId;
	private String companyName;
	@JsonFormat(pattern = "yyyy-MM-dd") // Optional
	private LocalDate dos;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // by default it expects this pattern, howerver its optional for this kind of pattern
	private LocalDateTime dtos;
	private List<Project> projectsInfo;
	@JsonFormat(pattern = "HH:mm:ss")  //optional for this pattern
	private LocalTime tos;
}
