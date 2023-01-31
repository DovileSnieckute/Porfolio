package com.example.demo.plan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.object.ObjectEntity;
import com.example.demo.object.ObjectRepository;
import com.example.demo.supplier.SupplierEntity;
import com.example.demo.supplier.SupplierRepository;

@Service
public class PlanService {

	@Autowired
	PlanMapper mapper;

	@Autowired
	PlanRepository repository;

	@Autowired
	SupplierRepository supplierRepository;
	
	@Autowired
	ObjectRepository objectRepository;
	

	public List<PlanDto> findAllPlans() {

		List<PlanEntity> plan = (List<PlanEntity>) repository.findAll();

		return mapper.toDtoList(plan);
	}

	public PlanDto findById(Long id) {

		PlanEntity plan = repository.findById(id).orElse(null);

		PlanDto planDto = mapper.toDto(plan);

		return planDto;

	}

	public PlanDto createPlan(PlanDto planDto) {

		PlanEntity plan = mapper.fromDto(planDto);

		repository.save(plan);

		return mapper.toDto(plan);
	}

	public PlanDto updatePlan(PlanDto planDto, Long id) {

		PlanEntity plan = mapper.fromDto(planDto);

		plan.setId(id);

		SupplierEntity supplier = supplierRepository.findById(plan.getSupplier().getId()).orElse(null);

		plan.setSupplier(supplier);

		repository.save(plan);

		return mapper.toDto(plan);
	}

	public void deletePlan(Long id) {

		List<ObjectEntity> list = objectRepository.findAllByPlan_Id(id);
		for(ObjectEntity entity : list) {
			
			entity.setPlan(null);
			objectRepository.save(entity);
		}
			
			repository.deleteById(id);
		
		
	}

	public List<PlanDto> findPlanBySupplierId(Long supplierId) {

		List<PlanEntity> plans = repository.findAllBySupplier_Id(supplierId);

		return mapper.toDtoList(plans);
	}

}
