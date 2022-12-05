package com.healthcare.doctorServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthcare.dao.DoctorDAO;
import com.healthcare.util.ConnectionProvider;


@WebServlet("/NewPassword")
public class newPassword extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String newPassword = req.getParameter("newPassword");
		System.out.println("newPassword" +newPassword);
		String confirmPassword = req.getParameter("confirmPassword");
		RequestDispatcher dispatcher = null;
		
//		DoctorDAO doctorDao=new DoctorDAO(ConnectionProvider.getconnection());
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","gayathri@0312");
			PreparedStatement prepareStatement = connection.prepareStatement("update doctor set password=? where email=?");
			prepareStatement.setString(1, newPassword);
			prepareStatement.setString(2, (String) session.getAttribute("email"));
			System.out.println("email "+session.getAttribute("email"));


			int rowCount = prepareStatement.executeUpdate();
			if (rowCount > 0) {
				req.setAttribute("status", "resetSuccess");
				dispatcher = req.getRequestDispatcher("doctor_login.jsp");
			} else {
				req.setAttribute("status", "resetFailed");
				dispatcher = req.getRequestDispatcher("doctor/ChangePassword.jsp");
			}
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	}
	

//if (newPassword != null && confirmPassword != null && newPassword.equals(confirmPassword)) {
//	if (doctorDao.saveNewPassword(email, newPassword)) {
//		req.setAttribute("status", "resetSuccess");
//		dispatcher = req.getRequestDispatcher("../doctor_login.jsp");
//	} else {
//		req.setAttribute("status", "resetFailed");
//		dispatcher = req.getRequestDispatcher("doctor/ChangePassword.jsp");
//	}
//	}else {
//		req.setAttribute("status", "resetFailed");
//	
//}