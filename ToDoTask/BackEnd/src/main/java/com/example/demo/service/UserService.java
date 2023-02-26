package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepo;


@Service
public class UserService {
	
	@Autowired
	UserMapper mapper;
	
	@Autowired
	UserRepo repository;
	
	public UserDto findById(Long id) {
		
		User user = repository.findById(id).orElse(null);
		
		UserDto userDto = mapper.toDto(user);
		
		return userDto;
		
	}
	
	public UserDto createUser(UserDto userDto) {
		
		User user = mapper.fromDto(userDto);
		
		repository.save(user);
		
		return mapper.toDto(user);
	}
	
	public UserDto updateUser(UserDto userDto) {
		
		User user = mapper.fromDto(userDto);
		
		repository.save(user);
		
		return mapper.toDto(user);
	}
	
	public void deleteUser(Long id) {
		
		repository.deleteById(id);
	}
	
	public List<UserDto> findAllUsers(){
		
		List<User> users = (ArrayList<User>) repository.findAll();
		
		return mapper.toDtoList(users);
		
	}

}
