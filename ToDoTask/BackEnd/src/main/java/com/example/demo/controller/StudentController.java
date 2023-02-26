package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentRepo studentRepo;

	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentMapper mapper;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{id}")
	public StudentDto find(@PathVariable(name="id") Long id) {
		
		
		return studentService.findById(id);
	}
	
	@PostMapping("/post")
	public StudentDto postDto(@RequestBody StudentDto student) {
		
		
		return studentService.createStudent(student);
		
	}
	
	@PutMapping("/put")
	public StudentDto putDto(@RequestBody StudentDto student) {
		

		return studentService.updateStudent(student);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteDto(@PathVariable(name="id") Long id) {
		
		studentService.deleteStudent(id);

	}
	
	@GetMapping("/find-by-personal-code/{personalCode}")
	public StudentDto findByPersonalCode(@PathVariable String personalCode) {
		
		Student student = studentService.findStudentByPersonalCode(personalCode);
		
		return mapper.toDto(student);
	}
	
	@GetMapping("/find-by-first-name/{firstName}")
	public List<StudentDto> findByFirstname(@PathVariable String firstName) {
		
		List<Student> student = studentService.findByFirstNameStartingWith(firstName);
		
		return mapper.toStudentList(student);
	}
	
	@GetMapping("/count/{firstName}")
	public Long countByFirstNameStartingWith(@PathVariable String firstName) {
		
		return studentService.countByFirstNameStartingWith(firstName);
		

	}
	
	
		

	

	}
	

