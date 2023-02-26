package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.StudentRepo;


@Service
public class StudentService {
		
	@Autowired
	StudentRepo repository;
	
	@Autowired
	StudentMapper mapper;
	
	public StudentDto findById(Long id) {
		
		Student student = repository.findById(id).orElse(null);
		
		StudentDto studentDto = mapper.toDto(student);
		
		return studentDto;
	}
	
	public List<StudentDto> findAllStudents(){
				
		List<Student> universities = (ArrayList<Student>) repository.findAll();
		
		return mapper.toStudentList(universities);
		
	}
	


	public StudentDto createStudent(StudentDto studentDto) {
		
		Student student = mapper.fromDto(studentDto);
		
		repository.save(student);
		
		return mapper.toDto(student);
		
	}
	
	public StudentDto updateStudent(StudentDto studentDto) {
		
		Student student = mapper.fromDto(studentDto);
		
		repository.save(student);
		
		return mapper.toDto(student);
		
		
	}
	
	public void deleteStudent(Long id) {
		
		repository.deleteById(id);
	}
	
	public List<StudentDto> findStudentByUniversityId(Long universityId){
		
		List<Student> students = repository.findAllByUniversity_Id(universityId);
		
		return mapper.toStudentList(students);
	}
	
	public List<StudentDto> findStudentByCourseId(Long courseId){
		
		List<Student> students = repository.findAllByCourses_Id(courseId);
		
		return mapper.toStudentList(students);
	}
	
	public Student findStudentByPersonalCode(String personalCode) {
		
		return repository.findByPersonalCode(personalCode);
		
	}
	
	public List<Student> findByFirstNameStartingWith(String firstName) {
		
		return repository.findByFirstNameStartingWith(firstName);
		
	}
	
	public Long countByFirstNameStartingWith(String firstName) {

		return repository.countByFirstNameStartingWith(firstName);

	}
	
	
}
