package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.PersonalCodeService;

@RestController
public class PersonalCodeController {
	
	@Autowired
	PersonalCodeService personalCodeService;
	
	@PostMapping("/personalcode")
	public boolean codeValidation(@RequestBody String code) {
		
		
		return personalCodeService.personalCode(code);
		
	}

}
