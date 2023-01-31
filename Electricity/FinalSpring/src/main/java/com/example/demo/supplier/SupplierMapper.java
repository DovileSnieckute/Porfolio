package com.example.demo.supplier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.plan.PlanService;

@Service
public class SupplierMapper {

	@Autowired
	PlanService planService;

	public SupplierDto toDto(SupplierEntity entity) {

		if (entity == null) {
			return null;
		}

		SupplierDto dto = new SupplierDto();

		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setPlans(planService.findPlanBySupplierId(entity.getId()));

		return dto;

	}

	public SupplierEntity fromDto(SupplierDto dto) {

		if (dto == null) {
			return null;
		}

		SupplierEntity entity = new SupplierEntity();

		entity.setId(dto.getId());
		entity.setName(dto.getName());

		return entity;

	}

	public List<SupplierDto> toDtoList(List<SupplierEntity> entities) {

		List<SupplierDto> dtos = new ArrayList<>();

		for (SupplierEntity entity : entities) {
			dtos.add(toDto(entity));
		}

		return dtos;

	}

}
