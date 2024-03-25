package com.example.labsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.labsystem.model.Appointment;
import com.example.labsystem.repositories.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repo;

    public List<Appointment> listAll() {
        return repo.findAll();
    }

    public void save(Appointment appointment) {
        repo.save(appointment);
    }

    public Appointment get(long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

    public byte[] getPdfContentById(long id) {
        Appointment appointment = repo.findById(id).orElse(null);

        if (appointment != null) {
            return appointment.getPdf();
        } else {
            throw new RuntimeException("Appointment not found with id: " + id);
        }
    }
}
