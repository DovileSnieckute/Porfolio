package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Courses;

@Repository
public interface CoursesRepo extends CrudRepository<Courses, Long>{
	
	public List<Courses> findAllByStudents_Id(Long studentId);

}
