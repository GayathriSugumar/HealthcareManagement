package com.healthcare.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthcare.dao.UserDAO;
import com.healthcare.dto.UserEntity;
import com.healthcare.util.ConnectionProvider;

@WebServlet("/UserResgister")
public class UserServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String fullName=req.getParameter("fullName");
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			
			UserEntity	userEntity=new UserEntity(fullName, email, password);
			
			UserDAO userDao=new UserDAO(ConnectionProvider.getconnection());
		
			HttpSession session=req.getSession();
			
			boolean result=userDao.SaveUserEntity(userEntity);
			
			if(result) {
				session.setAttribute("success", "Register successfully");
				resp.sendRedirect("user_login.jsp");
				System.out.println("Register Successfully");
			}else {
				session.setAttribute("error", "Something went wrong!..Try again");
				resp.sendRedirect("user_login.jsp");
				System.out.println("Something went Wrong!..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
