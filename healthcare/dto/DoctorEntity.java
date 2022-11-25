package com.healthcare.dto;

public class DoctorEntity {
	
	private int id;
	private String fullName;
	private String dob;
	private String qualification;
	private String specialistName;
	private String email;
	private String mobile;
	private String password;
	
	public DoctorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoctorEntity(String fullName, String dob, String qualification, String specialistName, String email,
			String mobile, String password) {
		super();
		this.fullName = fullName;
		this.dob = dob;
		this.qualification = qualification;
		this.specialistName = specialistName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}
	

	
	public DoctorEntity(int id, String fullName, String dob, String qualification, String specialistName, String email,
			String mobile, String password) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dob = dob;
		this.qualification = qualification;
		this.specialistName = specialistName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSpecialistName() {
		return specialistName;
	}

	public void setSpecialistName(String specialistName) {
		this.specialistName = specialistName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DoctorEntity [id=" + id + ", fullName=" + fullName + ", dob=" + dob + ", qualification=" + qualification
				+ ", specialistName=" + specialistName + ", email=" + email + ", mobile=" + mobile + ", password="
				+ password + "]";
	}
	
	
	

	
}
