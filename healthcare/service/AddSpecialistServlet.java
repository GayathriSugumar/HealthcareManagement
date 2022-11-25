package com.healthcare.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthcare.dao.SpecialistDAO;
import com.healthcare.dto.AdminEntity;
import com.healthcare.dto.SpecialistEntity;
import com.healthcare.util.ConnectionProvider;

@WebServlet("/addSpecialist")
public class AddSpecialistServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String specialistName=req.getParameter("specialistName");
	
		//SpecialistEntity specialist=new SpecialistEntity();
		
		SpecialistDAO specialistDao=new SpecialistDAO(ConnectionProvider.getconnection());
		
		boolean flag=specialistDao.addSpecialist(specialistName);
		
		HttpSession session = req.getSession();
		
		
		if (flag) {

			session.setAttribute("success","Specialist Added");
			resp.sendRedirect("admin/index.jsp");

			System.out.println("Login Susseccfully!");
		} else {
			session.setAttribute("error", "Somthing went wrong!Try again");
			resp.sendRedirect("admin/index.jsp");
			System.out.println("Somthing went wrong!Try again");
		}
		
	}
	
	

}
