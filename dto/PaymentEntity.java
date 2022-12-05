package com.healthcare.dto;

public class PaymentEntity {

	private int id;
	
	private String email;
	
	private String otp;

	private String appointmentFees;
	
	public PaymentEntity() {
		
	}

	public PaymentEntity(String email, String otp, String appointmentFees) {
		super();
		System.out.println(otp+"Payment entity");
		this.email = email;
		this.otp = otp;
		this.appointmentFees = appointmentFees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getAppointmentFees() {
		return appointmentFees;
	}

	public void setAppointmentFees(String appointmentFees) {
		this.appointmentFees = appointmentFees;
	}

	@Override
	public String toString() {
		return "PaymentEntity [id=" + id + ", email=" + email + ", otp=" + otp + ", appointmentFees=" + appointmentFees
				+ "]";
	}

	
	
	
}
