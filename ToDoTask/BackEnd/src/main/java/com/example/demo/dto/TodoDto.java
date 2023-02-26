package com.example.demo.dto;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TodoDto {
	
	Long id;
	
	@NotBlank(message = "Title is required")
	String title;
	
	@NotBlank(message = "Content is required")
	String content;
	
	@NotBlank(message = "Date is required")
	String dueDate;
	
	private Long userId;

}
