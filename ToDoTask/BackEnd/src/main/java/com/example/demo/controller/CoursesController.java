package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CoursesDto;
import com.example.demo.service.CoursesService;

@RestController
@RequestMapping("/courses")
public class CoursesController {
	
	@Autowired
	private CoursesService coursesService;
	
	
	@GetMapping("/{id}")
	public CoursesDto find(@PathVariable(name="id") Long id) {
		
		
		return coursesService.findById(id);
	}
	
	@PostMapping("/post")
	public CoursesDto postDto(@RequestBody CoursesDto course) {
		
		
		return coursesService.createCourse(course);
		
	}
	
	@PutMapping("/put")
	public CoursesDto putDto(@RequestBody CoursesDto course) {
		

		return coursesService.updateCourse(course);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteDto(@PathVariable(name="id") Long id) {
		
		coursesService.deleteCourse(id);

	}
		

}
