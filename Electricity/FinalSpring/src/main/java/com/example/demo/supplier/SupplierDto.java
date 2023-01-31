package com.example.demo.supplier;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.plan.PlanDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDto {

	private Long id;

	private String name;

	private List<PlanDto> plans = new ArrayList<>();

}
