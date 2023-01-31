package com.example.demo.object;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepository extends CrudRepository<ObjectEntity, Long> {

	public List<ObjectEntity> findAllByUsers_Id(Long userId);
	
	public List<ObjectEntity> findAllByPlan_Id(Long userId);

}
