package com.learn.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name is required")
	@Column(nullable = false)
	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Enter a valid email")
	@Column(nullable = false, unique = true)
	private String email;

	@NotBlank(message = "Course is required")
	@Column(nullable = false)
	private String course;

	@NotNull(message = "Marks are required")
	@Min(value = 0, message = "Marks cannot be less than 0")
	@Max(value = 100, message = "Marks cannot exceed 100")
	@Column(nullable = false)
	private Double marks;

	public Student() {
	}

	public Student(String name, String email, String course, Double marks) {
		this.name = name;
		this.email = email;
		this.course = course;
		this.marks = marks;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCourse() {
		return course;
	}

	public Double getMarks() {
		return marks;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String n) {
		this.name = n;
	}

	public void setEmail(String e) {
		this.email = e;
	}

	public void setCourse(String c) {
		this.course = c;
	}

	public void setMarks(Double m) {
		this.marks = m;
	}
}
