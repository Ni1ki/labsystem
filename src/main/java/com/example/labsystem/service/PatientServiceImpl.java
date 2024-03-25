package com.example.labsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.labsystem.dto.PatientDto;
import com.example.labsystem.model.Patient;
import com.example.labsystem.repositories.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Patient save(PatientDto patientDto) {
		Patient patient = new Patient(patientDto.getName(),patientDto.getAge(),patientDto.getNic(),patientDto.getPhoneno(),patientDto.getRole(),patientDto.getAddress(),patientDto.getEmail(),passwordEncoder.encode(patientDto.getPassword()));
		return patientRepository.save(patient);
	}

}
