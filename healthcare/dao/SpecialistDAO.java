package com.healthcare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.healthcare.dto.SpecialistEntity;

public class SpecialistDAO {
	
	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public SpecialistDAO(Connection connection) {
		super();
		this.connection = connection;
		System.out.println("Invoked SpecialistDAO");
	}
	
	public boolean addSpecialist(String specialist) {
		System.out.println("Invoked addSpecialist()");
		boolean flag=false;
		try {
			String sqlStatement = "insert into specialist(specialistName) values(?)";

			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			prepareStatement.setString(1, specialist);
			System.out.println(specialist);
			int result = prepareStatement.executeUpdate();
			if(result == 1) {
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}
	
	public List<SpecialistEntity> getAllSpecialist(){
		List<SpecialistEntity> list=new ArrayList<SpecialistEntity>();
		SpecialistEntity specialistEntity=null;
		
		try {
			String sqlStatement = "select * from specialist";

			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
		
			ResultSet result=prepareStatement.executeQuery();
			while(result.next()) {
				specialistEntity=new SpecialistEntity();
				specialistEntity.setId(result.getInt(1));
				specialistEntity.setSpecialistName(result.getString(2));
				list.add(specialistEntity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

}
