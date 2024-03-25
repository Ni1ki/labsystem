package com.example.labsystem.service;

//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.labsystem.dto.PatientDto;
import com.example.labsystem.model.Patient;

@Service
public interface PatientService {
	
	Patient save (PatientDto patientDto);
	
//	UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;


}
