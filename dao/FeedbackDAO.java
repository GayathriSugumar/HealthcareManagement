package com.healthcare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.healthcare.dto.FeedbackEntity;

public class FeedbackDAO {

	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public FeedbackDAO(Connection connection) {
		super();
		this.connection = connection;
		System.out.println("Invoked FeedbackDAO");
	}
	
	public boolean SaveFeedbackEntity(FeedbackEntity Feedback) {
		System.out.println("Invoked addFeedback()");
		boolean flag=false;
		
		try {
			String sqlStatement = "insert into Feedback(Name,review) values(?,?)";

			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			prepareStatement.setString(1, Feedback.getName());
			prepareStatement.setString(2, Feedback.getReview());

			int result = prepareStatement.executeUpdate();
			if (result == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return flag;

	}
	
	
	public List<FeedbackEntity> getAllFeedbacks(){
		System.out.println("Invoked GetAllFeedback");
		List<FeedbackEntity>list=new ArrayList<FeedbackEntity>();
		FeedbackEntity feedback=null;
		try {
			String sqlStatement = "select * from Feedback "; 
			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
			
			ResultSet result=prepareStatement.executeQuery();
			
			while (result.next()) {
				
				feedback=new FeedbackEntity();
				
				feedback.setId(result.getInt(1));
				feedback.setName(result.getString(2));
				feedback.setReview(result.getString(3));
				list.add(feedback);
			}
			System.out.println(feedback);
			System.out.println("Feedback added!..");
				
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Somthing went wrong!.Feedback not added");
		}
		return list;
		
	}
}
	
//	public List<FeedbackEntity> getAllFeedbacks(){
//		System.out.println("Invoked getAllFeedbacks()");
//		List<FeedbackEntity> list= new ArrayList<FeedbackEntity>();
//		FeedbackEntity feedback=null;
//		
//		try {
//			
//			String sqlStatement = "select * from Feedback order by id desc"; 
//			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);
//			
//			ResultSet result=prepareStatement.executeQuery();
//			
//			while (result.next()) {
//				
//				feedback=new FeedbackEntity();
//				
//				feedback.setId(result.getInt(1));
//				feedback.setName(result.getString(2));
//				feedback.setReview(result.getString(3));
//				list.add(feedback);
//				
//			}
//			System.out.println(feedback);
//			System.out.println("Feedback added!..");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Somthing went wrong!.Feedback not added");
//		}
//		
//		return list;
//	}
	

