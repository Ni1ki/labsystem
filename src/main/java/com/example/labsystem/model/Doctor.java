package com.example.labsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
    private String name;
    private int phoneno;
    private String slmc;
    private String specialized;
    
	public Doctor() {
		
	}

	public Doctor(Long id, String name, int phoneno, String slmc, String specialized) {
		
		this.id = id;
		this.name = name;
		this.phoneno = phoneno;
		this.slmc = slmc;
		this.specialized = specialized;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}

	public String getSlmc() {
		return slmc;
	}

	public void setSlmc(String slmc) {
		this.slmc = slmc;
	}

	public String getSpecialized() {
		return specialized;
	}

	public void setSpecialized(String specialized) {
		this.specialized = specialized;
	}
	
	

}
