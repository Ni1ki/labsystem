package com.example.labsystem.dto;

public class PatientDto {
	
//	private int id;
	private String name;
    private int age;
    private String nic;
    private int phoneno;
    private String role;
    private String address;
    private String email;
    private String password;
    
	public PatientDto(String name, int age, String nic, int phoneno, String role, String address, String email,String password) {
		super();
		this.name = name;
		this.age = age;
		this.nic = nic;
		this.phoneno = phoneno;
		this.role = role;
		this.address = address;
		this.email = email;
		this.password = password;
	}
    
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public int getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}  

}
