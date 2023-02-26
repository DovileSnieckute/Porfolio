package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UniversityDto;
import com.example.demo.entity.University;
import com.example.demo.mapper.UniversityMapper;
import com.example.demo.repository.UniversityRepo;

@Service
public class UniversityService {
		
	@Autowired
	UniversityRepo repository;
	
	@Autowired
	UniversityMapper mapper;
	
	public UniversityDto findById(Long id) {
		
		University university = repository.findById(id).orElse(null);
		
		UniversityDto universityDto = mapper.toDto(university);
		
		return universityDto;
	}
	
	public List<UniversityDto> findAllUniversities(){
				
		List<University> universities = (ArrayList<University>) repository.findAll();
		
		return mapper.toDtoList(universities);
		
	}
	


	public UniversityDto createUniversity(UniversityDto universityDto) {
		
		University university = mapper.fromDto(universityDto);
		
		repository.save(university);
		
		return mapper.toDto(university);
		
	}
	
	public UniversityDto updateUniversity(UniversityDto universityDto) {
		
		University university = mapper.fromDto(universityDto);
		
		repository.save(university);
		
		return mapper.toDto(university);
		
		
	}
	
	public void deleteUniversity(Long id) {
		
		repository.deleteById(id);
	}
	
	
}
