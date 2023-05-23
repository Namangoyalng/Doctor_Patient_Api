package com.doctor.service;

import java.util.List;

import javax.validation.Valid;

import com.doctor.entities.Doctor;

public interface DoctorService {

	void saveDoctor(@Valid Doctor doctor);

	List<Doctor> getDocList();

	List<Doctor> getDocListbycity(String city);

	List<Doctor> getDocListbycityspec(String city, String speciality);

	Doctor getDocByID(int did);

	Doctor updatePhoneById(Doctor doctor);

	Doctor deleteDoctor(int id);

}
