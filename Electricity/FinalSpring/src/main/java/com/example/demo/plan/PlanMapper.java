package com.example.demo.plan;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.object.ObjectService;
import com.example.demo.supplier.SupplierEntity;

@Service
public class PlanMapper {

	@Autowired
	ObjectService objectService;

	public PlanDto toDto(PlanEntity entity) {

		if (entity == null) {
			return null;
		}
		PlanDto dto = new PlanDto();

		dto.setId(entity.getId());
		dto.setEnergyType(entity.getEnergyType());
		dto.setFixedPeriod(entity.getFixedPeriod());
		dto.setPeriod(entity.getPeriod());
		dto.setPrice(entity.getPrice());
		dto.setStartDate(entity.getStartDate());
		dto.setTimeZone(entity.getTimeZone());
		dto.setTitle(entity.getTitle());

		if (entity.getSupplier() != null) {
			dto.setSupplierId(entity.getSupplier().getId());
		}
		dto.setObjects(objectService.findObjectByUserId(entity.getId()));

		return dto;

	}

	public PlanEntity fromDto(PlanDto dto) {

		if (dto == null) {
			return null;
		}

		PlanEntity entity = new PlanEntity();

		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setEnergyType(dto.getEnergyType());
		entity.setFixedPeriod(dto.getFixedPeriod());
		entity.setPeriod(dto.getPeriod());
		entity.setPrice(dto.getPrice());
		entity.setStartDate(dto.getStartDate());
		entity.setTimeZone(dto.getTimeZone());

		SupplierEntity supplier = new SupplierEntity();

		supplier.setId(dto.getSupplierId());

		entity.setSupplier(supplier);

		return entity;
	}

	public List<PlanDto> toDtoList(List<PlanEntity> entities) {

		List<PlanDto> dtos = new ArrayList<>();

		for (PlanEntity entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;

	}

}
