package com.example.demo.supplier;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier")
@CrossOrigin(origins = { "http://localhost:3000", "http://127.0.0.1:3000" })

public class SupplierController {

	@Autowired
	SupplierService supplierService;

	@GetMapping("/{id}")
	public SupplierDto findById(@PathVariable(name = "id") Long id) {

		return supplierService.findById(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/post")
	public SupplierDto createSupplier(@Valid @RequestBody SupplierDto planDto) {

		return supplierService.createSupplier(planDto);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public SupplierDto updatePlan(@Valid @RequestBody SupplierDto planDto, @PathVariable(name = "id") Long id) {

		return supplierService.updateSupplier(planDto, id);

	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public void deleteSupplier(@PathVariable(name = "id") Long id) {

		supplierService.deleteSupplier(id);
	}

	@GetMapping("")
	public List<SupplierDto> findAllSuppliers() {

		return supplierService.findAllSuppliers();
	}

}
