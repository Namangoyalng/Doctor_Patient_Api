package com.doctor.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Patient {

	@Id
	@GeneratedValue
	private int pid;

	@NotNull(message = "Name is required")
	@Pattern(regexp = "[A-Za-z' ']*", message = "Only alphabets are allowed")
	@Length(min = 3, message = "Atleast three characters are required")
	private String name;

	@NotNull(message = "City is required")
	@Pattern(regexp = "[A-Za-z' ']*", message = "Only alphabets are allowed")
	@Length(max = 20, message = "Not more than twenty characters are allowed")
	private String city;

	@Email(message = "Invalid email. Please try again.")
	private String email;

	@NotNull(message = "Phone is required")
	@Pattern(regexp = "[0-9]*", message = "Only digits are allowed")
	@Length(min = 10, max = 10, message = "Only 10 digist are allowed")
	private String pat_phone;

	@NotNull(message = "Symptom is required")
	@Pattern(regexp = "Arthritis|Backpain|Tissue injuries|Dysmenorrhea|Skin infection|Skin burn|Ear pain", message = "Sorry invalid symptom")
	private String symptom;

}
