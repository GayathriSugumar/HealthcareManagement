package com.healthcare.service;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthcare.dao.DoctorDAO;
import com.healthcare.dto.DoctorEntity;
import com.healthcare.util.ConnectionProvider;



@WebServlet("/addDoctor")
public class AddDoctorServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String fullName=req.getParameter("fullName");
			String dob=req.getParameter("dob");
			String qualification=req.getParameter("qualification");
			String specialistName=req.getParameter("specialistName");
			String email=req.getParameter("email");
			String mobile=req.getParameter("mobile");
			String password=req.getParameter("password");
			
			DoctorEntity doctor=new DoctorEntity(fullName, dob, qualification, specialistName, email, mobile, password);
			
			DoctorDAO doctorDao=new DoctorDAO(ConnectionProvider.getconnection());
			
			HttpSession session=req.getSession();
			
			if (doctorDao.registerDoctor(doctor)) {
				session.setAttribute("succMsg", "Doctor Added Sucessfully..");
				resp.sendRedirect("admin/doctor.jsp");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
				resp.sendRedirect("admin/doctor.jsp");
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	
}
