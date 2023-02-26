package com.example.demo.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.example.demo.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursesDto {
	
	private Long id;
	
	@NotBlank(message = "Title is required")
	private String title;
	
	private List<StudentDto> students;

}
