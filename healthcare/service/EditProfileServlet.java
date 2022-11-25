package com.healthcare.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthcare.dao.DoctorDAO;
import com.healthcare.dto.DoctorEntity;
import com.healthcare.util.ConnectionProvider;

@WebServlet("/doctorEditProfile")
public class EditProfileServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String fullName=req.getParameter("fullName");
			String dob=req.getParameter("dob");
			String qualification=req.getParameter("qualification");
			String specialistName=req.getParameter("specialistName");
			String email=req.getParameter("email");
			String mobile=req.getParameter("mobile");
						
			int id=Integer.parseInt(req.getParameter("id"));
			
			DoctorEntity doctor=new DoctorEntity(id,fullName, dob, qualification, specialistName, email, mobile, "");
			
			DoctorDAO doctorDao=new DoctorDAO(ConnectionProvider.getconnection());
			
			HttpSession session=req.getSession();
			
			if (doctorDao.editDoctorProfile(doctor)) {
				DoctorEntity updateDoctor=doctorDao.getDoctorById(id);
				session.setAttribute("succMsgd", "Doctor Updated Sucessfully..");
				session.setAttribute("doctorObj", updateDoctor);
				resp.sendRedirect("doctor/edit_Profile.jsp");
			} else {
				session.setAttribute("errorMsgd", "something wrong on server");
				resp.sendRedirect("doctor/edit_Profile.jsp");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
	}
	
	


