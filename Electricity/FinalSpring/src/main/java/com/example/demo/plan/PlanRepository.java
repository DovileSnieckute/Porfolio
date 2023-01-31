package com.example.demo.plan;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends CrudRepository<PlanEntity, Long> {

	public List<PlanEntity> findAllBySupplier_Id(Long supplierId);
}
