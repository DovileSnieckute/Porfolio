package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CoursesDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Courses;
import com.example.demo.entity.Student;
import com.example.demo.service.CoursesService;
import com.example.demo.service.StudentService;

@Service
public class CoursesMapper {
	
//	@Autowired
//	StudentService studentService;

	public CoursesDto toDto(Courses entity) {

		if (entity == null) {
			return null;
		}
		CoursesDto dto = new CoursesDto();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
//		dto.setStudents(fromStudentEntityToDto(entity.getStudents()));
		
//		dto.setStudents(studentService.findStudentByCourseId(entity.getId()));
		
		List<StudentDto> students = new ArrayList<>();
		for(Student student : entity.getStudents()) {
			
			StudentDto studentCourse = new StudentDto();
			studentCourse.setId(student.getId());
			students.add(studentCourse);
			
		}
		
		entity.setStudents(entity.getStudents());
		
		

		return dto;
	}

	public Courses fromDto(CoursesDto dto) {
		if (dto == null) {
			return null;
		}

		Courses entity = new Courses();
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
//		entity.setStudents(fromStudentDtoToEntity(dto.getStudents()));
		
		List<Student> students = new ArrayList<>();
		for(StudentDto studentsDto : dto.getStudents()) {
			Student student = new Student();
			student.setId(studentsDto.getId());
			students.add(student);
		}
		entity.setStudents(students);

		return entity;

	}

	public List<CoursesDto> toCoursesList(List<Courses> entities) {

		List<CoursesDto> courses = new ArrayList<>();

		for (Courses entity : entities) {
			courses.add(toDto(entity));
		}
		return courses;

	}
	
//	 public List<Courses> fromDto(List<CoursesDto> dtos) {
//	        List<Courses> entities = new ArrayList<>();
//
//	        for (CoursesDto dto : dtos) {
//	            entities.add(fromDto(dto));
//	        }
//
//	        return entities;
//	    }
//
//	    private StudentDto fromStudentEntityToDto(Student entity) {
//	        if (entity == null) {
//	            return null;
//	        }
//
//	        StudentDto dto = new StudentDto();
//
//	        dto.setId(entity.getId());
//	        dto.setFirstName(entity.getFirstName());
//	        dto.setLastName(entity.getLastName());
//	        dto.setPersonalCode(entity.getPersonalCode());
//
//	        return dto;
//	    }
//
//	    private List<StudentDto> fromStudentEntityToDto(List<Student> entities) {
//	        List<StudentDto> dtos = new ArrayList<>();
//
//	        for (Student entity : entities) {
//	            dtos.add(fromStudentEntityToDto(entity));
//	        }
//
//	        return dtos;
//	    }
//
//	    private Student fromStudentDtoToEntity(StudentDto dto) {
//	        if (dto == null) {
//	            return null;
//	        }
//
//	        Student entity = new Student();
//
//	        entity.setId(dto.getId());
//	        entity.setFirstName(dto.getFirstName());
//	        entity.setLastName(dto.getLastName());
//	        entity.setPersonalCode(dto.getPersonalCode());
//
//	        return entity;
//	    }
//
//	    private List<Student> fromStudentDtoToEntity(List<StudentDto> dtos) {
//	        List<Student> entities = new ArrayList<>();
//
//	        for (StudentDto dto : dtos) {
//	            entities.add(fromStudentDtoToEntity(dto));
//	        }
//
//	        return entities;
//	    }

}
