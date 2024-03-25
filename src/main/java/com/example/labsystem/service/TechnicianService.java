package com.example.labsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.labsystem.model.Technician;
import com.example.labsystem.repositories.TechnicianRepository;

@Service
public class TechnicianService {
	
	@Autowired
    private TechnicianRepository repo;
    
    public List<Technician> listAll() {
        return repo.findAll();
    }
     
    public void save(Technician std) {
        repo.save(std);
    }
     
    public Technician get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }

}
