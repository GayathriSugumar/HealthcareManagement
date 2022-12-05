package com.healthcare.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthcare.dao.FeedbackDAO;
import com.healthcare.dao.UserDAO;
import com.healthcare.dto.FeedbackEntity;
import com.healthcare.dto.UserEntity;
import com.healthcare.util.ConnectionProvider;

@WebServlet("/Feedback")
public class Feedback extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String Name=req.getParameter("Name");
			String review=req.getParameter("comment");
			
			FeedbackEntity feedback=new FeedbackEntity(Name, review);
			FeedbackDAO feedbackDao=new FeedbackDAO(ConnectionProvider.getconnection());
		
			HttpSession session=req.getSession();
			
//			boolean result=feedbackDao.SaveFeedbackEntity(feedback);
			
			if(feedbackDao.SaveFeedbackEntity(feedback)) {
				
				resp.sendRedirect("Review.jsp");
				System.out.println("Feedback Added ");
			}else {
				
				resp.sendRedirect("../FeedBack.jsp");
				System.out.println("Something went Wrong!..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	}
	
	


