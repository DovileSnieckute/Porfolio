package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "university")

public class University {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@NotBlank(message = "Name is required")
	@Column(name = "name")
	private String name;
	
	@NotBlank(message = "Code is required")
	@Column(name = "code")
	private String code;
	
	@Min(value = 0, message = "Establishment year cannot be less than zero")
	@Column(name = "establishment_year")
	private Integer establishmentYear;
	
	@NotBlank(message = "Address is required")
	@Column(name = "address")
	private String address;
	
	
	@Column(name = "rating")
	private Integer rating;
	
	@Email(message = "Wrong email format")
	@Column(name = "email")
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "university")
	private List<Student> students;
	

}
