package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.TodoDto;
import com.example.demo.entity.TodoTask;
import com.example.demo.mapper.TodoMapper;
import com.example.demo.repository.TodoRepo;

@Service
public class TodoTaskService {
	
	@Autowired
	TodoMapper mapper;
	
	@Autowired
	TodoRepo repository;
	
	public String todoToUpperCase(String title) {
		
		return title.toUpperCase();
		
	}
	
	public TodoDto findById(Long id) {
		
		TodoTask todoTask = repository.findById(id).orElse(null);
		
		TodoDto todoDto = mapper.toDto(todoTask);
		
		return todoDto;
		
	}
	
	public TodoDto createTodo(TodoDto todoDto) {
		
		TodoTask todoTask = mapper.fromDto(todoDto);
		
		repository.save(todoTask);
		
		return mapper.toDto(todoTask);
	}
	
	public TodoDto updateTodo(TodoDto todoDto) {
		
		TodoTask todoTask = mapper.fromDto(todoDto);
		
		repository.save(todoTask);
		
		return mapper.toDto(todoTask);
	}
	
	public void deleteTodo(Long id) {
		
		repository.deleteById(id);
	}
	
	public List<TodoDto> findAllTodos(){
		
		List<TodoTask> todos = (ArrayList<TodoTask>) repository.findAll();
		
		return mapper.toDtoList(todos);
		
	}
	
	public List<TodoDto> findTodoByUserId(Long userId){
		
		List<TodoTask> todos = repository.findAllByUser_Id(userId);
		
		return mapper.toDtoList(todos);
	}

}
