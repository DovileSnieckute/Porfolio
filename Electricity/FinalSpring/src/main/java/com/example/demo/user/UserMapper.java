package com.example.demo.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.object.ObjectDto;
import com.example.demo.object.ObjectEntity;

@Service
public class UserMapper {

	public UserDto toDto(UserEntity entity) {

		if (entity == null) {
			return null;
		}
		UserDto dto = new UserDto();

		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setSurname(entity.getSurname());
		dto.setEmail(entity.getEmail());
		dto.setPassword(entity.getPassword());

		List<ObjectDto> objects = new ArrayList<>();
		for (ObjectEntity object : entity.getObjects()) {

			ObjectDto userObject = new ObjectDto();
			userObject.setId(object.getId());
			objects.add(userObject);
		}
		dto.setObjects(objects);

		List<Roles> roles = new ArrayList<>();
		for (Role role : entity.getRole()) {

			roles.add(role.getRole());
		}

		dto.setRole(roles);

		return dto;

	}

	public UserEntity fromDto(UserDto dto) {

		if (dto == null) {
			return null;
		}

		UserEntity entity = new UserEntity();

		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setSurname(dto.getSurname());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());

		List<ObjectEntity> objects = new ArrayList<>();
		for (ObjectDto objectDto : dto.getObjects()) {

			ObjectEntity userObject = new ObjectEntity();
			userObject.setId(objectDto.getId());
			objects.add(userObject);
		}
		entity.setObjects(objects);

		return entity;

	}

	public List<UserDto> toDtoList(List<UserEntity> entities) {

		List<UserDto> dtos = new ArrayList<>();

		for (UserEntity entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;

	}

}
