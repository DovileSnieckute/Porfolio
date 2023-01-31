package com.example.demo.object;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.plan.PlanEntity;
import com.example.demo.plan.PlanRepository;
import com.example.demo.user.UserRepository;

@Service
public class ObjectService {

	@Autowired
	ObjectMapper mapper;

	@Autowired
	ObjectRepository repository;

	@Autowired
	PlanRepository planRepository;
	
	@Autowired
	UserRepository userRepository;
	

	public List<ObjectDto> findObjectByUserId(Long userId) {

		List<ObjectEntity> objects = repository.findAllByUsers_Id(userId);

		return mapper.toDtoList(objects);
	}

	public ObjectDto findById(Long id) {

		ObjectEntity object = repository.findById(id).orElse(null);

		ObjectDto objectDto = mapper.toDto(object);

		return objectDto;
	}

	public ObjectDto createObject(ObjectDto objectDto) {

		ObjectEntity object = mapper.fromDto(objectDto);

		if(object.getPlan() != null) {
		PlanEntity plan = planRepository.findById(object.getPlan().getId()).orElse(null);

		object.setPlan(plan);
		}

		repository.save(object);

		return mapper.toDto(object);
	}

	public ObjectDto updateObject(ObjectDto objectDto, Long id) {

		ObjectEntity object = mapper.fromDto(objectDto);

		object.setId(id);

		if(object.getPlan() != null) {
		PlanEntity plan = planRepository.findById(object.getPlan().getId()).orElse(null);

		object.setPlan(plan);
		}

		repository.save(object);

		return mapper.toDto(object);
	}

	public void deleteObject(Long id) {

		repository.deleteById(id);
	}

	public List<ObjectDto> findAllObjects() {

		List<ObjectEntity> objects = (ArrayList<ObjectEntity>) repository.findAll();

		return mapper.toDtoList(objects);

	}

}
