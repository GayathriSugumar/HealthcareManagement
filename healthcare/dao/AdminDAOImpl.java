package com.healthcare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthcare.dto.AdminEntity;
import com.healthcare.util.ConnectionProvider;

public class AdminDAOImpl {

	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public AdminDAOImpl(Connection connection) {
		super();
		this.connection = connection;
		System.out.println("Invoked AdminDAOImpl");
	}

	public boolean AdminSaveEntity(AdminEntity saveAdmin) {
		System.out.println("Invoked Admin SaveEntity");
		boolean flag = false;
		try {
			String sqlStatement = "insert into admin(email,password) values(?,?)";
			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			prepareStatement.setString(1, saveAdmin.getEmail());
			System.out.println(saveAdmin.getEmail());
			prepareStatement.setString(2, saveAdmin.getPassword());
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;

	}

//	public boolean ChangePassword(int userId, String oldPassword) {
//		System.out.println("Invoked ChangePassword()");
//		boolean flag = false;
//
//		try {
//			String sqlStatement = "select * from userDetails where id=? and password=?";
//
//			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
//			prepareStatement.setInt(1, userId);
//			prepareStatement.setString(2, oldPassword);
//
//			ResultSet result = prepareStatement.executeQuery();
//			while (result.next()) {
//				flag = true;
//			}
//			System.out.println("Password has been change Successfully!..");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Password has not been change!..");
//		}
//		return flag;
//	}
//
//	public boolean saveNewPassword(int userId, String newPassword) {
//		System.out.println("Invoked saveNewPassword");
//		boolean flag = false;
//
//		try {
//			String sqlStatement = "update userDetails set password=? where id=?";
//
//			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
//			prepareStatement.setString(1, newPassword);
//			prepareStatement.setInt(2, userId);
//
//			int result = prepareStatement.executeUpdate();
//			if (result == 1) {
//				flag = true;
//			}
//			System.out.println("Password has been updated");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Password has not been update !..");
//		}
//		return flag;
//	}

}
