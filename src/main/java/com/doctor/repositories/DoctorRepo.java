package com.doctor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.doctor.entities.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

	@Query("from Doctor where city=:arg1")
	List<Doctor> findbycity(@Param("arg1") String city);

	@Query("from Doctor where city=:arg1 AND speciality =:arg2")
	List<Doctor> findbycityspec(@Param("arg1") String city, @Param("arg2") String speciality);

	@Query("from Doctor where city=:arg1 and speciality=:arg2")
	List<Doctor> findByCityAndSpec(@Param("arg1") String city, @Param("arg2") String speciality);

}
