package com.doctor.service;

import java.util.List;

import javax.validation.Valid;

import com.doctor.entities.Doctor;
import com.doctor.entities.Patient;

public interface PatientService {

	void savePatient(@Valid Patient patient);

	Patient deletePatient(int id);

	Patient getPatient(int id);



	

	List<Doctor> getDoctorBySymptom(String city, String symptom);

}
