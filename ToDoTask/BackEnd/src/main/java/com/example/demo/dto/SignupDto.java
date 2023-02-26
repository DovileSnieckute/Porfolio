package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {
	
	@NotBlank(message = "Name is required")
	private String name;
	
	@NotBlank(message = "Surname is required")
	private String surname;

	@NotBlank
	@Size(max = 50)
	private String email;
	
	@NotBlank
	@Size(min = 6, max = 20)
	private String password;
	
	@NotBlank
	@Size(min = 6, max = 20)
	private String repeatPassword;
}
