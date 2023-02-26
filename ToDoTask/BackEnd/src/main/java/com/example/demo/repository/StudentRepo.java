package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {

	public List<Student> findAllByUniversity_Id(Long universityId);
	
	public List<Student> findAllByCourses_Id(Long courseId);
	
	public Student findByPersonalCode(String personalCode);
	
	public List<Student> findByFirstNameStartingWith (String firstName);
	
	public Long countByFirstNameStartingWith (String firstName);

}
