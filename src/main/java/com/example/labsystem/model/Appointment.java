package com.example.labsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appointment {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
    private int testid;
    private String testname;
    private int patientid;
    private String date;
    private String time;
    private String status;
    private String result;
    private byte[] pdf;
    
	public Appointment() {
		
	}

	public Appointment(Long id, int testid, String testname, int patientid, String date, String time,String status,String result,byte[] pdf) {
		
		this.id = id;
		this.testid = testid;
		this.testname = testname;
		this.patientid = patientid;
		this.date = date;
		this.time = time;
		this.status = status;
		this.result = result;
		this.pdf = pdf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTestid() {
		return testid;
	}

	public void setTestid(int testid) {
		this.testid = testid;
	}

	public String getTestname() {
		return testname;
	}

	public void setTestname(String testname) {
		this.testname = testname;
	}

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}  
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}  
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	} 
	
	public byte[] getPdf() {
		return pdf;
	}

	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	} 

}
