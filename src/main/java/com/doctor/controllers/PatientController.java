package com.doctor.controllers;

import java.util.List;
	
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.entities.Doctor;
import com.doctor.entities.Patient;
import com.doctor.handler.PatientNotFoundException;
import com.doctor.service.PatientService;

@RestController
@RequestMapping("patient")
public class PatientController {
	@Autowired
	private PatientService patser;
	
	
	@PostMapping("create")
	public ResponseEntity<Patient> createPat(@Valid @RequestBody Patient patient) {
		patser.savePatient(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body(patient);
	}
	@DeleteMapping("delete/byid")
	public ResponseEntity<Patient> deleteListOfPatById(@RequestParam int id) {
		Patient patient = patser.deletePatient(id);
		if (patient == null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(patient);
	}
	@GetMapping("suggest")
	public ResponseEntity<List<Doctor>> findByLocationAndSymptoms(@RequestParam int id) {
        Patient patient = patser.getPatient(id);
        List<Doctor> list=patser.getDoctorBySymptom(patient.getCity(),patient.getSymptom());
        return ResponseEntity.ok(list);
      
    }
	
}
