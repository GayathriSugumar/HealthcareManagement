package com.healthcare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.healthcare.dto.AppointmentEntity;

public class AppointmentDAO {

	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public AppointmentDAO(Connection connection) {
		super();
		this.connection = connection;
		System.out.println("Invoked AppointmentDAO");
	}

	public boolean addAppointment(AppointmentEntity appointment) {
		System.out.println("Invoked ADD Appointment()");
		boolean flag=false;
		
		try {
			String sqlStatement = "insert into appoinment(userId, fullName, gender, age, appointmentDate, email, mobile, illness, doctorId, address, status) values(?,?,?,?,?,?,?,?,?,?,?)"; 
			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			
			prepareStatement.setInt(1, appointment.getUserId());
			System.out.println(appointment.getUserId());
	
			prepareStatement.setString(2, appointment.getFullName());
			prepareStatement.setString(3, appointment.getGender());
			prepareStatement.setString(4, appointment.getAge());
			prepareStatement.setString(5, appointment.getAppointmentDate());
			prepareStatement.setString(6, appointment.getEmail());
			prepareStatement.setString(7, appointment.getMobile());
			prepareStatement.setString(8, appointment.getIllness());
			prepareStatement.setInt(9, appointment.getDoctorId());
			prepareStatement.setString(10, appointment.getAddress());
			prepareStatement.setString(11, appointment.getStatus());
		
			int result = prepareStatement.executeUpdate();
			if (result == 1) {
				flag = true;
				
			}
			System.out.println("Appointment Details Added into Database Succssfully!...");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("somthing went wrong!...Appointment Details not Added!...");
			
		}
		return flag;
	}
	
	public List<AppointmentEntity> getAllAppointmentsByUserId(int userId){
		System.out.println("Invoked getAllAppointmentsByUserId()");
		List<AppointmentEntity> list= new ArrayList<AppointmentEntity>();
		AppointmentEntity appointment=null;
		
		try {
			
			String sqlStatement = "select * from appoinment where userId=?"; 
			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			prepareStatement.setInt(1, userId);
			
			ResultSet result=prepareStatement.executeQuery();
			while (result.next()) {
				appointment=new AppointmentEntity();
				appointment.setId(result.getInt(1));
				appointment.setUserId(result.getInt(2));
				appointment.setFullName(result.getString(3));
				appointment.setGender(result.getString(4));
				appointment.setAge(result.getString(5));
				appointment.setAppointmentDate(result.getString(6));
				appointment.setEmail(result.getString(7));
				appointment.setMobile(result.getString(8));
				appointment.setIllness(result.getString(9));
				appointment.setDoctorId(result.getInt(10));
				appointment.setAddress(result.getString(11));
				appointment.setStatus(result.getString(12));
				list.add(appointment);
				
			}
			System.out.println("UserLogin->Personal Appointment List!..");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Appointment Details Not Available here !..");
		}
		
		return list;
	}
	
	public List<AppointmentEntity> getAllAppointmentsByDoctorId(int doctorId){
		System.out.println("Invoked getAllAppointmentsByDoctorId()");
		List<AppointmentEntity> list= new ArrayList<AppointmentEntity>();
		AppointmentEntity appointment=null;
		
		try {
			
			String sqlStatement = "select * from appoinment where doctorId=?"; 
			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			prepareStatement.setInt(1, doctorId);
			
			ResultSet result=prepareStatement.executeQuery();
			while (result.next()) {
				appointment=new AppointmentEntity();
				appointment.setId(result.getInt(1));
				appointment.setUserId(result.getInt(2));
				appointment.setFullName(result.getString(3));
				appointment.setGender(result.getString(4));
				appointment.setAge(result.getString(5));
				appointment.setAppointmentDate(result.getString(6));
				appointment.setEmail(result.getString(7));
				appointment.setMobile(result.getString(8));
				appointment.setIllness(result.getString(9));
				appointment.setDoctorId(result.getInt(10));
				appointment.setAddress(result.getString(11));
				appointment.setStatus(result.getString(12));
				list.add(appointment);
				
			}
			System.out.println(appointment);
			System.out.println("Doctor Login->Personal Appointment list !..");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Somthing went wrong!..Appointment Status not available!..");
		}
		
		return list;
	}
	
	
	public AppointmentEntity getAllAppointmentsById(int id){
		System.out.println("Invoked getAllAppointmentsById()");
		
		AppointmentEntity appointment=null;
		
		try {
			
			String sqlStatement = "select * from appoinment where id=?"; 
			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			prepareStatement.setInt(1, id);
			
			ResultSet result=prepareStatement.executeQuery();
			while (result.next()) {
				appointment=new AppointmentEntity();
				appointment.setId(result.getInt(1));
				appointment.setUserId(result.getInt(2));
				appointment.setFullName(result.getString(3));
				appointment.setGender(result.getString(4));
				appointment.setAge(result.getString(5));
				appointment.setAppointmentDate(result.getString(6));
				appointment.setEmail(result.getString(7));
				appointment.setMobile(result.getString(8));
				appointment.setIllness(result.getString(9));
				appointment.setDoctorId(result.getInt(10));
				appointment.setAddress(result.getString(11));
				appointment.setStatus(result.getString(12));
				
			}
			System.out.println(appointment);
			System.out.println("User Reference-Individual appointmentList!..");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Appointment Details Not added !..");
		}
		
		return appointment;
	}
	
	public boolean updateStatusComment(int id,int doctorId,String comment ) {
		System.out.println("Invoked UpdateStatusComment()");
		boolean flag=false;
		
		try {
			String sqlStatement = "update appoinment set status=? where id=? and doctorId=?"; 
			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			prepareStatement.setString(1, comment);
			prepareStatement.setInt(2, id);
			prepareStatement.setInt(3, doctorId);
			System.out.println("Doctor Comment- Comment Updated into Patient Status");
			
			int result = prepareStatement.executeUpdate();
			if (result == 1) {
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public List<AppointmentEntity> getAllAppointments(){
		System.out.println("Invoked getAllAppointments()");
		List<AppointmentEntity> list= new ArrayList<AppointmentEntity>();
		AppointmentEntity appointment=null;
		
		try {
			
			String sqlStatement = "select * from appoinment order by id desc"; 
			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			
			ResultSet result=prepareStatement.executeQuery();
			
			while (result.next()) {
				
				appointment=new AppointmentEntity();
				
				appointment.setId(result.getInt(1));
				appointment.setUserId(result.getInt(2));
				appointment.setFullName(result.getString(3));
				appointment.setGender(result.getString(4));
				appointment.setAge(result.getString(5));
				appointment.setAppointmentDate(result.getString(6));
				appointment.setEmail(result.getString(7));
				appointment.setMobile(result.getString(8));
				appointment.setIllness(result.getString(9));
				appointment.setDoctorId(result.getInt(10));
				appointment.setAddress(result.getString(11));
				appointment.setStatus(result.getString(12));
				list.add(appointment);
				
			}
			System.out.println(appointment);
			System.out.println("Admin Reference-Total Appointment Status!..");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Somthing went wrong!..Appointment Status not available!..");
		}
		
		return list;
	}
	
}
