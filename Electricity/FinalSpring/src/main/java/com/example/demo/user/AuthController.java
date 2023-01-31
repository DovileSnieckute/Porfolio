package com.example.demo.user;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.object.ObjectDto;
import com.example.demo.object.ObjectEntity;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.security.services.UserDetailsImpl;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = { "http://localhost:3000", "http://127.0.0.1:3000" })
public class AuthController {

	@Autowired
	AuthService authService;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/signup")
	public UserDto signup(@Valid @RequestBody SignupDto signupDto) throws Exception {

		return authService.signup(signupDto);

	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		String jwtToken = jwtUtils.generateJwtToken(userDetails);

		UserDto newUserDto = new UserDto();
		newUserDto.setId(userDetails.getId());
		newUserDto.setEmail(userDetails.getEmail());
		newUserDto.setName(userDetails.getUsername());
		newUserDto.setSurname(userDetails.getSurname());
		newUserDto.setPassword(userDetails.getPassword());
		
		List<Roles> roles = new ArrayList<>();
		for (Role role : userDetails.getRole()) {

			roles.add(role.getRole());
		}

		newUserDto.setRole(roles);
		
		List<ObjectDto> objects = new ArrayList<>();
		for (ObjectEntity object : userDetails.getObjects()) {

			ObjectDto userObject = new ObjectDto();
			userObject.setId(object.getId());
			userObject.setAddress(object.getAddress());
			userObject.setObjectNumber(object.getObjectNumber());

			objects.add(userObject);
		}
		newUserDto.setObjects(objects);

		return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwtToken)
				.header("Access-Control-Expose-Headers", "Authorization").body(newUserDto);
	}

}
