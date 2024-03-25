package com.example.labsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.labsystem.model.Medicaltest;
import com.example.labsystem.repositories.MedicaltestRepository;

@Service
public class MedicaltestService {
	
	@Autowired
    private MedicaltestRepository repo;
    
    public List<Medicaltest> listAll() {
        return repo.findAll();
    }
     
    public void save(Medicaltest std) {
        repo.save(std);
    }
     
    public Medicaltest get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }

}
