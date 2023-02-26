package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user1")

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	
	
	@NotBlank(message = "Name is required")
	@Column(name="name")
	private String name;
	
	@NotBlank(message = "Surname is required")
	@Column(name="surname")
	private String surname;
	
	@Email(message = "Wrong email format")
	@Column(name="email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<TodoTask> todos;
	
	@ManyToMany
	@JoinTable(
			name="user_roles", 
			joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns= @JoinColumn(name = "role_id"))
	private List<Role> role;
	
	

}
