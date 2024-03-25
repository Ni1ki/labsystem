package com.example.labsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.labsystem.model.Doctor;
import com.example.labsystem.repositories.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
    private DoctorRepository repo;
    
    public List<Doctor> listAll() {
        return repo.findAll();
    }
     
    public void save(Doctor std) {
        repo.save(std);
    }
     
    public Doctor get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }

}
