package com.example.demo.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.example.demo.object.ObjectEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "electricity_user")
public class UserEntity {
	
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
	
	@NotBlank(message = "Password is required")
	@Column(name = "password")
	private String password;
	
	@ManyToMany
	@JoinTable(
			name="user_object", 
			joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns= @JoinColumn(name = "object_id"))
	private List<ObjectEntity> objects = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(
			name="user_role", 
			joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns= @JoinColumn(name = "role_id"))
	private List<Role> role;
}
