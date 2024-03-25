package com.example.labsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.labsystem.model.Patient;
import com.example.labsystem.repositories.PatientRepository;

@Service
public class CustomPatientDetailsService implements UserDetailsService {
	
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Patient patient = patientRepository.findByEmail(username);
		if (patient == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		return new CustomPatientDetail(patient);
	}

}
