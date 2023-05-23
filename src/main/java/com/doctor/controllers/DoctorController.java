package com.doctor.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.entities.Doctor;
import com.doctor.service.DoctorService;

@RestController
@RequestMapping("doctor")
public class DoctorController {

	@Autowired
	private DoctorService docser;

	@PostMapping("create")
	public ResponseEntity<Doctor> createDoc(@Valid @RequestBody Doctor doctor) {
		docser.saveDoctor(doctor);
		return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
	}

	@GetMapping("docList")
	public ResponseEntity<List<Doctor>> getDocListMapper() {
		List<Doctor> list = docser.getDocList();
//		if (list.isEmpty()) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
		
		return ResponseEntity.ok(list);
	}

	@GetMapping("docList/bycity")
	public ResponseEntity<List<Doctor>> getDocListbycityMapper(@RequestParam String city) {
		List<Doctor> list = docser.getDocListbycity(city);
		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(list);
	}

	@GetMapping("docList/bycity_speciality")
	public ResponseEntity<List<Doctor>> getDocListbycityspecMapper(@RequestParam String city,
			@RequestParam String speciality) {
		List<Doctor> list = docser.getDocListbycityspec(city, speciality);
		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(list);
	}

	@PatchMapping("update/phone/{did}/{phoneno}")
	public ResponseEntity<Doctor> updateDocPhoneById(@PathVariable int did, @PathVariable String phoneno) {
		Doctor doctor = docser.getDocByID(did);
		if (doctor == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		doctor.setDoc_phone(phoneno);
		Doctor doc = docser.updatePhoneById(doctor);
		return ResponseEntity.ok(doc);
	}

	@DeleteMapping("delete/byid")
	public ResponseEntity<Doctor> deleteListOfDocById(@RequestParam int id) {
		Doctor doctor = docser.deleteDoctor(id);
		if (doctor == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(doctor);
	}
	
	
}
