package com.filipeloesch.application.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Name field cannot be null or empty")
	@Pattern(regexp = "^(?:[A-ZÀ-ÿ][a-zÀ-ÿ]*)(?: [A-ZÀ-ÿ][a-zÀ-ÿ]*)*$", 
	message = "Name field must contain only letters, the first being uppercase and the following lowercase")
	@Size(min = 3, max = 100, message = "Name field must be 3 to 100 characters long")
	private String name;
	
	@NotBlank(message = "Email field cannot be null or empty")
	@Email(message = "Email field must be formatted correctly: example@example.com")
	private String email;
	
	@Pattern(regexp = "^\\(\\d{2}\\) \\d{4,5}-\\d{4}$", 
			message = "Phone field must be formatted correctly: (12) 12345-1234 or (12) 1234-1234")
	private String phone;

	public User() {
	}

	public User(Integer id, String name, String email, String phone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
}
