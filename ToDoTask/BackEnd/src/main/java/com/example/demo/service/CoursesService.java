package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CoursesDto;
import com.example.demo.entity.Courses;
import com.example.demo.mapper.CoursesMapper;
import com.example.demo.repository.CoursesRepo;

@Service
public class CoursesService {
	
	@Autowired
	CoursesRepo repository;
	
	@Autowired
	CoursesMapper mapper;
	
	public CoursesDto findById(Long id) {
		
		Courses courses = repository.findById(id).orElse(null);
		
		CoursesDto coursesDto = mapper.toDto(courses);
		
		return coursesDto;
	}
	
	public List<CoursesDto> findAllCourses(){
				
		List<Courses> courses = (ArrayList<Courses>) repository.findAll();
		
		return mapper.toCoursesList(courses);
		
	}
	


	public CoursesDto createCourse(CoursesDto coursesDto) {
		
		Courses course = mapper.fromDto(coursesDto);
		
		repository.save(course);
		
		return mapper.toDto(course);
		
	}
	
	public CoursesDto updateCourse(CoursesDto courseDto) {
		
		Courses course = mapper.fromDto(courseDto);
		
		repository.save(course);
		
		return mapper.toDto(course);
		
		
	}
	
	public void deleteCourse(Long id) {
		
		repository.deleteById(id);
	}
	
	public List<CoursesDto> findCoursesByStudentId(Long studentId){
		
		List<Courses> course = repository.findAllByStudents_Id(studentId);
		
		return mapper.toCoursesList(course);
	}

}
