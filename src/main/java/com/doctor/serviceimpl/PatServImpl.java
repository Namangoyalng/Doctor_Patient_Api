package com.doctor.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.entities.Doctor;
import com.doctor.entities.Patient;
import com.doctor.handler.DoctorNotFoundException;
import com.doctor.handler.NoDocFoundAtLocationException;
import com.doctor.handler.NoDocFoundSymptomException;
import com.doctor.repositories.DoctorRepo;
import com.doctor.repositories.PatientRepo;
import com.doctor.service.PatientService;

@Service
public class PatServImpl implements PatientService {

	static final Map<String, String> mapper = new HashMap<>();
	static {
		mapper.put("Arthritis", "Orthopedic");
		mapper.put("Backpain", "Orthopedic");
		mapper.put("Tissue Injury", "Orthopedic");
		mapper.put("Dysmenorrhea", "Gynecology");
		mapper.put("Skin Infection", "Dermatology");
		mapper.put("Skin Burn", "Dermatology");
		mapper.put("Ear Pain", "ENT");
	}
	@Autowired
	private PatientRepo patRep;

	@Autowired
	private DoctorRepo docrep;

	public void savePatient(@Valid Patient patient) {
		patRep.save(patient);

	}

	public Patient deletePatient(int id) {
		Patient patient = patRep.findById(id).orElse(null);
		patRep.deleteById(id);
		return patient;
	}

	public Patient getPatient(int id) {
		return patRep.findById(id).orElse(null);
	}


	public List<Doctor> getDoctorBySymptom(String city, String symptom) {
		String speciality = mapper.get(symptom);
		List<Doctor> list= docrep.findByCityAndSpec(city, speciality);
		if(list.isEmpty()) {
			throw new NoDocFoundAtLocationException("no doctor found ");
		}
		return list;
		

	}

}
