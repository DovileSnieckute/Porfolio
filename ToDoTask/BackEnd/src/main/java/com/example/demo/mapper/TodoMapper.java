package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.TodoDto;
import com.example.demo.entity.TodoTask;
import com.example.demo.entity.User;

@Service
public class TodoMapper {

	
	public TodoDto toDto(TodoTask entity) {
		
		if(entity == null) {
			return null;
		}
		TodoDto dto = new TodoDto();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setContent(entity.getContent());
		dto.setDueDate(entity.getDueDate());
		dto.setUserId(entity.getUser().getId());

		return dto;
		
	}
	
	public TodoTask fromDto(TodoDto dto) {
		
		if(dto == null) {
			return null;
		}
		
		TodoTask entity = new TodoTask();
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setDueDate(dto.getDueDate());

		User user = new User();
		user.setId(dto.getUserId());
		entity.setUser(user);
		
		return entity;
	}
	
	public List<TodoDto> toDtoList(List<TodoTask> entities){
		
		List<TodoDto> dtos = new ArrayList<>();
		
		for(TodoTask entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
		
	}

}
