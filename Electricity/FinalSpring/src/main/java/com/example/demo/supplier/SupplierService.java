package com.example.demo.supplier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

	@Autowired
	SupplierMapper mapper;

	@Autowired
	SupplierRepository repository;

	public List<SupplierDto> findAllSuppliers() {

		List<SupplierEntity> supplier = (List<SupplierEntity>) repository.findAll();

		return mapper.toDtoList(supplier);
	}

	public SupplierDto findById(Long id) {

		SupplierEntity supplier = repository.findById(id).orElse(null);

		SupplierDto supplierDto = mapper.toDto(supplier);

		return supplierDto;

	}

	public SupplierDto createSupplier(SupplierDto supplierDto) {

		SupplierEntity supplier = mapper.fromDto(supplierDto);

		repository.save(supplier);

		return mapper.toDto(supplier);
	}

	public SupplierDto updateSupplier(SupplierDto supplierDto, Long id) {

		SupplierEntity supplier = mapper.fromDto(supplierDto);

		supplier.setId(id);

		repository.save(supplier);

		return mapper.toDto(supplier);
	}

	public void deleteSupplier(Long id) {

		repository.deleteById(id);
	}

}
