package com.example.demo.object;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.plan.PlanEntity;
import com.example.demo.user.UserDto;
import com.example.demo.user.UserEntity;

@Service
public class ObjectMapper {

	public ObjectDto toDto(ObjectEntity entity) {

		if (entity == null) {
			return null;
		}
		ObjectDto dto = new ObjectDto();

		dto.setId(entity.getId());
		dto.setObjectNumber(entity.getObjectNumber());
		dto.setAddress(entity.getAddress());

		List<UserDto> users = new ArrayList<>();
		for (UserEntity user : entity.getUsers()) {

			UserDto objectUser = new UserDto();
			objectUser.setId(user.getId());
			users.add(objectUser);
		}

		dto.setUsers(users);

		if (entity.getPlan() != null) {
			dto.setPlanId(entity.getPlan().getId());
		}

		return dto;

	}

	public ObjectEntity fromDto(ObjectDto dto) {

		if (dto == null) {
			return null;
		}

		ObjectEntity entity = new ObjectEntity();

		entity.setId(dto.getId());
		entity.setObjectNumber(dto.getObjectNumber());
		entity.setAddress(dto.getAddress());

		if(dto.getUsers() != null) {
		List<UserEntity> users = new ArrayList<>();
		for (UserDto usersDto : dto.getUsers()) {
			UserEntity user = new UserEntity();
			user.setId(usersDto.getId());
			users.add(user);
		}
		entity.setUsers(users);
		}

		if (dto.getPlanId() != null) {
			PlanEntity plan = new PlanEntity();

			plan.setId(dto.getPlanId());

			entity.setPlan(plan);

		}

		return entity;
	}

	public List<ObjectDto> toDtoList(List<ObjectEntity> entities) {

		List<ObjectDto> dtos = new ArrayList<>();

		for (ObjectEntity entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;

	}

}
