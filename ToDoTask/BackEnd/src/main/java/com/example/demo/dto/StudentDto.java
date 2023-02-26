package com.example.demo.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.example.demo.entity.Courses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
	
	private Long id;
	
	@NotBlank(message = "Name is required")
	private String firstName;
	
	@NotBlank(message = "Surname is required")
	private String lastName;
	
	@NotBlank(message = "Personal Code is required")
	private String personalCode;
	
	private Long universityId;
	
	private List<CoursesDto> courses;
	
//	private Long courseId;
	
	
	
	
	

}
