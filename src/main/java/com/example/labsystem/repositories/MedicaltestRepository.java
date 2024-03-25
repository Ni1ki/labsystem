package com.example.labsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.labsystem.model.Medicaltest;

@Repository
public interface MedicaltestRepository extends JpaRepository<Medicaltest, Long> {

}
