package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.University;
//kokio tipo id laukas (long)

@Repository
public interface UniversityRepo extends CrudRepository<University, Long> {

}
