package com.healthcare.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthcare.dao.DoctorDAO;
import com.healthcare.dao.UserDAO;
import com.healthcare.util.ConnectionProvider;

@WebServlet("/docterPassword")
public class DoctorPasswordServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId=Integer.parseInt(req.getParameter("userId"));
		String oldPassword=req.getParameter("oldPassword");
		String newPassword=req.getParameter("newPassword");
		
		DoctorDAO doctorDao=new DoctorDAO(ConnectionProvider.getconnection());
		HttpSession session=req.getSession();
		
		if (doctorDao.ChangePassword(userId, oldPassword)) 
		{
			if (doctorDao.saveNewPassword(userId, newPassword)) {
				session.setAttribute("succMsgd", "Password Change Sucessfully");
				resp.sendRedirect("doctor/edit_Profile.jsp");
				System.out.println("Password changed Successfully");
			} else {
				session.setAttribute("errorMsgd", "Something wrong on server");
				resp.sendRedirect("doctor/edit_Profile.jsp");
				System.out.println("Password has not not been changed");
			}
			
		} else {
			session.setAttribute("errorMsgd", "Something wrong on server");
			resp.sendRedirect("doctor/edit_Profile.jsp");
			System.out.println("Password has not not been changed");
		}
	}
	}

	
