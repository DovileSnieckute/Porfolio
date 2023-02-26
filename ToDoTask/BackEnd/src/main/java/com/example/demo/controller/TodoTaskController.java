package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TodoDto;
import com.example.demo.entity.TodoTask;
import com.example.demo.service.TodoTaskService;

@RestController
@RequestMapping("/todotask")
@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3000"})

public class TodoTaskController {
	
	@Autowired
	TodoTaskService todoTaskService;
	
	@PostMapping("/print")
	public TodoTask printToDoTask(@RequestBody TodoTask task) {
		
		System.out.println("task title: " + task.getTitle());
		System.out.println("task content: " + task.getContent());
		return task;
		
		
	}
	
	@PostMapping("/upper")
	public TodoTask TodoTaskService(@RequestBody TodoTask task) {
		
		task.setTitle(task.getTitle().toUpperCase());
		
		return task;
	}
	
	@PostMapping("/upper2")
	public TodoTask TodoTaskService2(@RequestBody TodoTask task) {
		
		task.setTitle(todoTaskService.todoToUpperCase(task.getTitle()));
		
		return task;
	}
	
	@GetMapping("/{id}")
	public TodoDto findById(@PathVariable(name="id") Long id) {
		
		return todoTaskService.findById(id);
	}
	
	@PostMapping("/post")
	public TodoDto createTodo(@Valid @RequestBody TodoDto todoDto) {
		
		return todoTaskService.createTodo(todoDto);
	}
	
	@PutMapping("/{id}")
	public TodoDto updateTodo(@Valid @RequestBody TodoDto todoDto, @PathVariable(name="id") Long id) {
		
		return todoTaskService.updateTodo(todoDto);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable(name="id") Long id) {
		

		todoTaskService.deleteTodo(id);
	}
	
	@GetMapping("")
	public List<TodoDto> findAllTodos(){
		
		return todoTaskService.findAllTodos();
	}


}
