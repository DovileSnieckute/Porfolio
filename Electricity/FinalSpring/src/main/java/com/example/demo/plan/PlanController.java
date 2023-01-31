package com.example.demo.plan;

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
@RequestMapping("/plan")
@CrossOrigin(origins = { "http://localhost:3000", "http://127.0.0.1:3000" })

public class PlanController {

	@Autowired
	PlanService planService;

	@GetMapping("/{id}")
	public PlanDto findById(@PathVariable(name = "id") Long id) {

		return planService.findById(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/post")
	public PlanDto createPlan(@Valid @RequestBody PlanDto planDto) {

		return planService.createPlan(planDto);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public PlanDto updatePlan(@Valid @RequestBody PlanDto planDto, @PathVariable(name = "id") Long id) {

		return planService.updatePlan(planDto, id);

	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public void deletePlan(@PathVariable(name = "id") Long id) {

		planService.deletePlan(id);
	}

	@GetMapping("")
	public List<PlanDto> findAllPlans() {

		return planService.findAllPlans();
	}

}
