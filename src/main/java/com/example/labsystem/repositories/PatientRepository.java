package com.example.labsystem.repositories;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.labsystem.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	Patient findByEmail (String email);
}