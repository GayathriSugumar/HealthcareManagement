package com.healthcare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthcare.dto.UserEntity;

public class UserDAO {

	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public UserDAO(Connection connection) {
		super();
		this.connection = connection;
		System.out.println("Invoked UserDao");
	}

	public boolean SaveUserEntity(UserEntity user) {
		System.out.println("Invoked SaveUserEntity()");
		boolean flag = false;
		try {
			String sqlStatement = "insert into userDetails(fullName,email,password) values(?,?,?)";

			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			prepareStatement.setString(1, user.getFullName());
			prepareStatement.setString(2, user.getEmail());
			prepareStatement.setString(3, user.getPassword());

			int result = prepareStatement.executeUpdate();
			if (result == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return flag;

	}

	public UserEntity ValidateUserLogin(String email, String password) {
		UserEntity user = null;

		try {
			String sqlStatement = "select * from userDetails where email=? and password=?";

			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);

			prepareStatement.setString(1, email);
			prepareStatement.setString(2, password);

			ResultSet result = prepareStatement.executeQuery();

			while (result.next()) {
				user = new UserEntity();
				user.setId(result.getInt(1));
				user.setFullName(result.getString(2));
				user.setEmail(result.getString(3));
				user.setPassword(result.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}

	public boolean ChangePassword(int userId, String oldPassword) {
		System.out.println("Invoked ChangePassword()");
		boolean flag = false;

		try {
			String sqlStatement = "select * from userDetails where id=? and password=?";

			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			prepareStatement.setInt(1, userId);
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
	
	public boolean saveNewPassword(int userId, String newPassword) {
		System.out.println("Invoked saveNewPassword");
		boolean flag = false;

		try {
			String sqlStatement = "update userDetails set password=? where id=?";

			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			prepareStatement.setString(1, newPassword);
			prepareStatement.setInt(2, userId);
			
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
	
}
