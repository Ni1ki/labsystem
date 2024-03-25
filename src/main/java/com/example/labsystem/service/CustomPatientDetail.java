package com.example.labsystem.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.labsystem.model.Patient;

public class CustomPatientDetail implements UserDetails {
	
	private Patient patient;

	public CustomPatientDetail(Patient patient) {
		this.patient = patient;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(() -> patient.getRole());
	}
	
	public Long getId() {
		return patient.getId();
	}
	
	public String getName() {
		return patient.getName();
	}
	
	public int getAge() {
		return patient.getAge();
	}
	
	public String getNic() {
		return patient.getNic();
	}
	
	public int getPhoneno() {
		return patient.getPhoneno();
	}
	
	public String getRole() {
		return patient.getRole();
	}
	
	public String getAddress() {
		return patient.getAddress();
	}
	
	@Override
	public String getUsername() {
		return patient.getEmail();
	}
	
	@Override
	public String getPassword() {
		return patient.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
