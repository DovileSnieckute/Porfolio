package com.example.demo.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserMapper userMapper;

	@Autowired
	PasswordEncoder passwordEncoder;

	public UserDto signup(SignupDto signupDto) throws Exception {

		if (userRepository.findByEmail(signupDto.getEmail()).isPresent()) {
			throw new Exception("Email" + signupDto.getEmail() + " is already in use");
		}

		if (!signupDto.getPassword().equals(signupDto.getRepeatPassword())) {
			throw new Exception("Passwords do not match");

		}

		UserEntity newUser = new UserEntity();
		newUser.setEmail(signupDto.getEmail());
		newUser.setPassword(passwordEncoder.encode(signupDto.getPassword()));
		newUser.setName(signupDto.getName());
		newUser.setSurname(signupDto.getSurname());

		if (signupDto.getRole() == null) {

			Role userRole = roleRepository.findByRole(Roles.ROLE_USER).orElseThrow();
			List<Role> userRoles = new ArrayList<>();

			userRoles.add(userRole);
			newUser.setRole(userRoles);

		}

		else {

			Role userRole = roleRepository.findByRole(signupDto.getRole()).orElseThrow();
			List<Role> userRoles = new ArrayList<>();

			userRoles.add(userRole);
			newUser.setRole(userRoles);
		}

		userRepository.save(newUser);

		return userMapper.toDto(newUser);

	}

}
