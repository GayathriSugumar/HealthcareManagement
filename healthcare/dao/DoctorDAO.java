package com.healthcare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.healthcare.dto.DoctorEntity;

public class DoctorDAO {

	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public DoctorDAO(Connection connection) {
		super();
		this.connection = connection;
		System.out.println("Invoked DoctorDAO");
	}

	public boolean registerDoctor(DoctorEntity doctor) {
		System.out.println("Invoked registerDoctor()");
		boolean flag = false;

		try {
			String sqlStatement = "insert into doctor(fullName, dob, qualification, specialistName, email, mobile, password) values(?,?,?,?,?,?,?)";

			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			prepareStatement.setString(1, doctor.getFullName());
			prepareStatement.setString(2, doctor.getDob());
			prepareStatement.setString(3, doctor.getQualification());
			prepareStatement.setString(4, doctor.getSpecialistName());
			prepareStatement.setString(5, doctor.getEmail());
			prepareStatement.setString(6, doctor.getMobile());
			prepareStatement.setString(7, doctor.getPassword());

			int result = prepareStatement.executeUpdate();
			if (result == 1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	public List<DoctorEntity> getAllDoctorEntity() {
		System.out.println("Invoked getAllDoctorEntity()");
		List<DoctorEntity> list = new ArrayList<DoctorEntity>();
		DoctorEntity doctor = null;
		try {
			String sqlStatement = "select * from doctor order by id desc";

			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {

				doctor = new DoctorEntity();

				doctor.setId(result.getInt(1));
				doctor.setFullName(result.getString(2));
				doctor.setDob(result.getString(3));
				doctor.setQualification(result.getString(4));
				doctor.setSpecialistName(result.getString(5));
				doctor.setEmail(result.getString(6));
				doctor.setMobile(result.getString(7));
				doctor.setPassword(result.getString(8));
				list.add(doctor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	public DoctorEntity getDoctorById(int id) {
		System.out.println("Invoked getDoctorById");
		DoctorEntity doctor = null;
		try {
			String sqlStatement = "select * from doctor where id=?";

			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			prepareStatement.setInt(1, id);
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {

				doctor = new DoctorEntity();

				doctor.setId(result.getInt(1));
				doctor.setFullName(result.getString(2));
				doctor.setDob(result.getString(3));
				doctor.setQualification(result.getString(4));
				doctor.setSpecialistName(result.getString(5));
				doctor.setEmail(result.getString(6));
				doctor.setMobile(result.getString(7));
				doctor.setPassword(result.getString(8));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return doctor;

	}

	public boolean UpdateDoctor(DoctorEntity doctor) {
		System.out.println("Invoked UpdateDoctor()");
		boolean flag = false;

		try {
			String sqlStatement = "update doctor set fullName=?, dob=?, qualification=?, specialistName=?, email=?, mobile=?, password=? where id=?";

			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			prepareStatement.setString(1, doctor.getFullName());
			prepareStatement.setString(2, doctor.getDob());
			prepareStatement.setString(3, doctor.getQualification());
			prepareStatement.setString(4, doctor.getSpecialistName());
			prepareStatement.setString(5, doctor.getEmail());
			prepareStatement.setString(6, doctor.getMobile());
			prepareStatement.setString(7, doctor.getPassword());
			prepareStatement.setInt(8, doctor.getId());
			int result = prepareStatement.executeUpdate();
			if (result == 1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	public boolean DeleteDoctor(int id) {
		System.out.println("Invoked DeleteDoctor()");
		boolean flag = false;
		try {
			String sqlStatement = "delete from doctor where id=?";
			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			prepareStatement.setInt(1, id);

			int result = prepareStatement.executeUpdate();
			if (result == 1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public DoctorEntity Login(String email, String password) {
		System.out.println("Invoked Doctor Login()");
		DoctorEntity doctor = null;

		try {

			String sqlStatement = "select * from doctor where email=? and password=?";
			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			prepareStatement.setString(1, email);
			prepareStatement.setString(2, password);

			ResultSet result = prepareStatement.executeQuery();

			while (result.next()) {

				doctor = new DoctorEntity();
				doctor = new DoctorEntity();

				doctor.setId(result.getInt(1));
				doctor.setFullName(result.getString(2));
				doctor.setDob(result.getString(3));
				doctor.setQualification(result.getString(4));
				doctor.setSpecialistName(result.getString(5));
				doctor.setEmail(result.getString(6));
				doctor.setMobile(result.getString(7));
				doctor.setPassword(result.getString(8));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctor;
	}
	
	public int countDoctor() {
		System.out.println("Invoked Count Doctors()");
		int i = 0;
		try {
			String sqlStatement = "select * from doctor";
			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			ResultSet result = prepareStatement.executeQuery();
			
			while (result .next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}
	
	public int countDoctorById(int doctorId) {
		System.out.println("Invoked Count DoctorById()");
		int i = 0;
		try {
			String sqlStatement = "select * from doctor where doctorId=?";
			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			prepareStatement.setInt(1, doctorId);
			ResultSet result = prepareStatement.executeQuery();
			
			while (result .next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}
	
	public int countAppointment() {
		System.out.println("Invoked count Appointment()");
		int i = 0;
		try {
			String sqlStatement = "select * from appoinment";
			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			ResultSet result = prepareStatement.executeQuery();
			
			while (result .next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}
	
	public int countUser() {
		System.out.println("Invoked count User()");
		int i = 0;
		try {
			String sqlStatement = "select * from userDetails";
			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			ResultSet result = prepareStatement.executeQuery();
			
			while (result .next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}
	
	public int countSpecialist() {
		System.out.println("Invoked count Specialist()");
		int i = 0;
		try {
			String sqlStatement = "select * from specialist";
			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			ResultSet result = prepareStatement.executeQuery();
			
			while (result .next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}
	
	public boolean ChangePassword(int doctorId, String oldPassword) {
		System.out.println("Invoked ChangePassword()");
		boolean flag = false;

		try {
			String sqlStatement = "select * from doctor where id=? and password=?";

			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			prepareStatement.setInt(1, doctorId);
			prepareStatement.setString(2, oldPassword);

			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				flag = true;
			}
			System.out.println("Password has been change Successfully!..");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Password has not been change!..");
		}
		return flag;
	}
	
	public boolean saveNewPassword(int doctorId, String newPassword) {
		System.out.println("Invoked saveNewPassword");
		boolean flag = false;

		try {
			String sqlStatement = "update doctor set password=? where id=?";

			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			prepareStatement.setString(1, newPassword);
			prepareStatement.setInt(2, doctorId);
			
			int result = prepareStatement.executeUpdate();
			if (result == 1) {
				flag = true;
			}
			System.out.println("Password has been updated");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Password has not been update !..");
		}
		return flag;
	}
	
	public boolean editDoctorProfile(DoctorEntity doctor) {
		System.out.println("Invoked UpdateDoctor()");
		boolean flag = false;

		try {
			String sqlStatement = "update doctor set fullName=?, dob=?, qualification=?, specialistName=?, email=?, mobile=? where id=?";

			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			prepareStatement.setString(1, doctor.getFullName());
			prepareStatement.setString(2, doctor.getDob());
			prepareStatement.setString(3, doctor.getQualification());
			prepareStatement.setString(4, doctor.getSpecialistName());
			prepareStatement.setString(5, doctor.getEmail());
			prepareStatement.setString(6, doctor.getMobile());
			prepareStatement.setInt(7, doctor.getId());
			int result = prepareStatement.executeUpdate();
			if (result == 1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}
}
