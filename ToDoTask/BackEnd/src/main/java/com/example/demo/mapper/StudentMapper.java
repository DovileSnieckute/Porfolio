package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CoursesDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Courses;
import com.example.demo.entity.Student;
import com.example.demo.entity.University;
import com.example.demo.service.CoursesService;



@Service
public class StudentMapper {
	
	@Autowired
	CoursesService courseService;
	public StudentDto toDto(Student entity) {
		
		if(entity == null) {
			return null;
		}
		StudentDto dto = new StudentDto();
		dto.setId(entity.getId());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setPersonalCode(entity.getPersonalCode());
		dto.setUniversityId(entity.getUniversity().getId());

		List<CoursesDto> courses = new ArrayList<>();
		for(Courses course : entity.getCourses()) {
			
			CoursesDto studentCourse = new CoursesDto();
			studentCourse.setId(course.getId());
			courses.add(studentCourse);
			
		}
		
		entity.setCourses(entity.getCourses());
		
		
		return dto;
	}
	
	public Student fromDto(StudentDto dto) {
		if(dto == null) {
			return null;
		}
		
		Student entity = new Student();
		entity.setId(dto.getId());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setPersonalCode(dto.getPersonalCode());
		
		University university = new University();
		university.setId(dto.getUniversityId());
		entity.setUniversity(university);
				
		List<Courses> courses = new ArrayList<>();
		for(CoursesDto courseDto : dto.getCourses()) {
			
			Courses studentCourse = new Courses();
			studentCourse.setId(courseDto.getId());
			courses.add(studentCourse);
			
		}
		
		entity.setCourses(courses);

		

		return entity;
		
	}
	
	public List<StudentDto> toStudentList(List<Student> entities){
		
		List<StudentDto> students = new ArrayList<>();
		
		for(Student entity : entities) {
			students.add(toDto(entity));
		}
		return students;
		
	}
}
