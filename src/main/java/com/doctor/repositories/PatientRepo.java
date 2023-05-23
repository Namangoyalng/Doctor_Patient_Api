package com.doctor.repositories;




import org.springframework.data.jpa.repository.JpaRepository;

import com.doctor.entities.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer>{
  

}
