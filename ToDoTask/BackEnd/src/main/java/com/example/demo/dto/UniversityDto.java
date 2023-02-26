package com.example.demo.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UniversityDto {
	
	private Long id;
	
	@NotBlank(message = "Name is required")
	private String name;
	
	@NotBlank(message = "Code is required")
	private String code;
	
	@Min(value = 0, message = "Establishment year cannot be less than zero")
	private Integer establishmentYear;
	
	@NotBlank(message = "Address is required")
	private String address;
	
	
	private Integer rating;
	
	@Email(message = "Wrong email format")
	private String email;
	
	private List<StudentDto> students;

}
