package com.example.labsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.labsystem.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
