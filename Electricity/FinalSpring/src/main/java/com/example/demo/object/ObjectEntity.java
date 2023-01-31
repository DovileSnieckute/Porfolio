package com.example.demo.object;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.plan.PlanEntity;
import com.example.demo.user.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "object")
public class ObjectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "object_number")
	private Integer objectNumber;

	@Column(name = "address")
	private String address;

	@ManyToMany
	@JoinTable(name = "user_object", joinColumns = @JoinColumn(name = "object_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	List<UserEntity> users = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "plan_id")
	private PlanEntity plan;

}
