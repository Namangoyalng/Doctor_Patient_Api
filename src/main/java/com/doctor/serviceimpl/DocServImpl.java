package com.doctor.serviceimpl;


import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.entities.Doctor;
import com.doctor.handler.DoctorNotFoundException;
import com.doctor.repositories.DoctorRepo;
import com.doctor.service.DoctorService;

@Service
public class DocServImpl implements DoctorService {

	@Autowired
	private DoctorRepo docRep;
	
	public void saveDoctor(@Valid Doctor doctor) {
		
		docRep.save(doctor);
	}
	
	public List<Doctor> getDocList() {
		List<Doctor> list = docRep.findAll();
		if(list.isEmpty()) {
			throw new DoctorNotFoundException("Nahi hai koi");
		}
		
		return list;
	}


	public List<Doctor> getDocListbycity(String city) {
			return docRep.findbycity(city);
	}


	public List<Doctor> getDocListbycityspec(String city, String speciality) {
		
		return docRep.findbycityspec(city,speciality);
	}

	
	public Doctor getDocByID(int did) {
		
		return docRep.findById(did).orElse(null);
	}


	public Doctor updatePhoneById(Doctor doctor) {
		
		return docRep.save(doctor);
	}

	@Override
	public Doctor deleteDoctor(int id) {
		
		Doctor doctor = docRep.findById(id).orElse(null);
		docRep.deleteById(id);
        return doctor;
	}

}
