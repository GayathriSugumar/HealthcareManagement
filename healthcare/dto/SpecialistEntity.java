package com.healthcare.dto;

public class SpecialistEntity {
	
	private int id;
	
	private String SpecialistName;
	
	public SpecialistEntity() {
		super();
		
	}
	

	public SpecialistEntity(int id, String specialistName) {
		super();
		this.id = id;
		SpecialistName = specialistName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpecialistName() {
		return SpecialistName;
	}

	public void setSpecialistName(String specialistName) {
		SpecialistName = specialistName;
	}

	@Override
	public String toString() {
		return "SpecialistEntity [id=" + id + ", SpecialistName=" + SpecialistName + "]";
	}

	
	

}
