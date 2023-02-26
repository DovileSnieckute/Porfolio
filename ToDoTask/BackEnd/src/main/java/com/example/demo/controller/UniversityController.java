package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UniversityDto;
import com.example.demo.service.UniversityService;

@RestController
@RequestMapping("/university")
public class UniversityController {
	
	@Autowired
	UniversityService universityService;

	@GetMapping("/{id}")
	public UniversityDto findById(@PathVariable(name="id") Long id) {
		
		return universityService.findById(id);
		
	}
	
	@GetMapping("")
	public List<UniversityDto> findAllUniversities(){
		
		return universityService.findAllUniversities();
	}
	
	@PostMapping("/post")
	public UniversityDto createUniversity(@Valid @RequestBody UniversityDto universityDto) {
		
		return universityService.createUniversity(universityDto);
	}
	
	@PutMapping("/{id}")
	public UniversityDto updateUniversity(@Valid @RequestBody UniversityDto universityDto, @PathVariable(name="id") Long id) {
		
		return universityService.updateUniversity(universityDto);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteUniversity(@PathVariable(name="id") Long id) {
		
		universityService.deleteUniversity(id);
	}
	
	
	
	

}
