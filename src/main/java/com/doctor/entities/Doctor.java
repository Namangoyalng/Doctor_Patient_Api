package com.doctor.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Doctor {

	@Id
	@GeneratedValue(generator = "doc_seq")
	@SequenceGenerator(name = "doc_seq", initialValue = 1, allocationSize = 1)
	private int did;

	@NotNull(message = "Name is required")
	@Pattern(regexp = "[A-Za-z' ']*", message = "Only alphabets are allowed")
	private String doc_name;

	@NotNull(message = "City is required")
	@Pattern(regexp = "Noida|Delhi|Faridabad", message = "Wrong city")
	private String city;

	@NotNull(message = "Phone is required")
	@Pattern(regexp = "[0-9]*", message = "Only digits are allowed")
	@Length(min = 10, max = 10, message = "Only 10 digist are allowed")
	private String doc_phone;

	@NotNull(message = "Speciality is required")
	@Pattern(regexp = "Orthopedic|Gynecology|Dermatology|ENT", message = "Only alphabets are allowed")
	private String speciality;

}
