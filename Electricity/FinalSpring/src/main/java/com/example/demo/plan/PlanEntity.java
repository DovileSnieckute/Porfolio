package com.example.demo.plan;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.example.demo.object.ObjectEntity;
import com.example.demo.supplier.SupplierEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plan")
public class PlanEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "start_date")
	private String startDate;

	@Column(name = "period")
	private Integer period;

	@Column(name = "fixed_period")
	private Integer fixedPeriod;

	@Column(name = "time_zone")
	private String timeZone;

	@Column(name = "energy_type")
	private String energyType;

	@Column(name = "price")
	private Double price;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "supplier_id")
	private SupplierEntity supplier;

	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "plan")
	private List<ObjectEntity> objects;

}
