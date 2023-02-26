package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getters setters
@Entity
@AllArgsConstructor //constructors
@NoArgsConstructor

public class Student {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@NotBlank(message = "Name is required")
	private String firstName;
	
	@NotBlank(message = "Surname is required")
	private String lastName;
	
	@NotBlank(message = "Personal Code is required")
	private String personalCode;
	
	
	@ManyToOne
	@JoinColumn(name = "university_id")
	private University university;
	
	@ManyToMany(mappedBy = "students")
	private List<Courses> courses;
	
}



