package com.example.labsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.labsystem.model.Technician;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {

}
