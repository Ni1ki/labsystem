package com.example.labsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Technician {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
    private String name;
    private String position;
    private int phoneno;
    
	public Technician() {
		
	}
	
	public Technician(Long id, String name, String position, int phoneno) {
		
		this.id = id;
		this.name = name;
		this.position = position;
		this.phoneno = phoneno;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
}
