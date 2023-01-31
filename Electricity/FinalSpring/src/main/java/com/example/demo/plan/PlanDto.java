package com.example.demo.plan;

import java.util.List;

import com.example.demo.object.ObjectDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanDto {

	private Long id;

	private String title;

	private String startDate;

	private Integer period;

	private Integer fixedPeriod;

	private String timeZone;

	private String energyType;

	private Double price;

	private Long supplierId;

	private List<ObjectDto> objects;
}
