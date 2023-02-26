package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UniversityDto;
import com.example.demo.entity.University;
import com.example.demo.service.StudentService;

@Service
public class UniversityMapper {
	
	@Autowired
	StudentService studentService;
	
	
public UniversityDto toDto(University entity) {
		
		if(entity == null) {
			return null;
		}
		UniversityDto dto = new UniversityDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCode(entity.getCode());
		dto.setAddress(entity.getAddress());
		dto.setEstablishmentYear(entity.getEstablishmentYear());
		dto.setRating(entity.getRating());
		dto.setEmail(entity.getEmail());
		
		dto.setStudents(studentService.findStudentByUniversityId(entity.getId()));
		
		return dto;
	}
//gausim uni paduosim unidto	
	public University fromDto(UniversityDto dto) {
		
		if(dto == null) {
			return null;
		}
		
		University entity = new University();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setCode(dto.getCode());
		entity.setAddress(dto.getAddress());
		entity.setEstablishmentYear(dto.getEstablishmentYear());
		entity.setRating(dto.getRating());
		entity.setEmail(dto.getEmail());
		
		return entity;
		
	}
	
	public List<UniversityDto> toDtoList(List<University> entities){
		
		List<UniversityDto> dtos = new ArrayList<>();
		
		for(University entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
		
	}
}
