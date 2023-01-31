package com.example.demo.user;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.example.demo.object.ObjectDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

	private Long id;

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Surname is required")
	private String surname;

	@NotBlank(message = "Email is required")
	@Email(message = "Wrong email format")
	private String email;

	@NotBlank(message = "Password is required")
	private String password;

	private List<Roles> role = new ArrayList<>();

	private List<ObjectDto> objects = new ArrayList<>();

}
