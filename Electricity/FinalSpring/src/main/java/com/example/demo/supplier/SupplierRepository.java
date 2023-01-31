package com.example.demo.supplier;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends CrudRepository<SupplierEntity, Long> {

	public List<SupplierEntity> findAllByPlans_Id(Long planId);

}
