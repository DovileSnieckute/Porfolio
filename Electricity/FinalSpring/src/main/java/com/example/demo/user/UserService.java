package com.example.demo.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserMapper mapper;

	@Autowired
	UserRepository repository;

	public UserDto findById(Long id) {

		UserEntity user = repository.findById(id).orElse(null);

		UserDto userDto = mapper.toDto(user);

		return userDto;

	}

	public UserDto createUser(UserDto userDto) {

		UserEntity user = mapper.fromDto(userDto);

		repository.save(user);

		return mapper.toDto(user);
	}

	public UserDto updateUser(UserDto userDto) {

		UserEntity user = mapper.fromDto(userDto);

		repository.save(user);

		return mapper.toDto(user);
	}

	public void deleteUser(Long id) {

		repository.deleteById(id);
	}

	public List<UserDto> findAllUsers() {

		List<UserEntity> users = (ArrayList<UserEntity>) repository.findAll();

		return mapper.toDtoList(users);

	}

}
