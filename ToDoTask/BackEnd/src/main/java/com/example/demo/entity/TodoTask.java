package com.example.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="todo_task")



public class TodoTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	Long id;
	
	@NotBlank(message = "Title is required")
	@Column(name="title")
	String title;
	
	@NotBlank(message = "Content is required")
	@Column(name="content")
	String content;
	
	@NotBlank(message = "Date is required")
	@Column(name="due_date")
	String dueDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
}
