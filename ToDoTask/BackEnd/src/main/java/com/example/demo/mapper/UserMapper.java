package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.TodoTaskService;

@Service
public class UserMapper {
	
	@Autowired
	TodoTaskService todoService;;
	
	public UserDto toDto(User entity) {
		
		if(entity == null) {
			return null;
		}
		UserDto dto = new UserDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setSurname(entity.getSurname());
		dto.setEmail(entity.getEmail());
		dto.setTodos(todoService.findTodoByUserId(entity.getId()));
		
		return dto;
		
		
	}
	
public User fromDto(UserDto dto) {
		
		if(dto == null) {
			return null;
		}
		
		User entity = new User();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setSurname(dto.getSurname());
		entity.setEmail(dto.getEmail());
		
		return entity;
		
	}
	
	public List<UserDto> toDtoList(List<User> entities){
		
		List<UserDto> dtos = new ArrayList<>();
		
		for(User entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
		
	}

}
