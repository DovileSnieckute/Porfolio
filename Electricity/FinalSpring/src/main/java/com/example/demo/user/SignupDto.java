package com.example.demo.user;

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
	private String email;

	@NotBlank(message = "Password is required")
	@Size(min = 6)
	private String password;

	@NotBlank
	@Size(min = 6)
	private String repeatPassword;

	private Roles role;
}
