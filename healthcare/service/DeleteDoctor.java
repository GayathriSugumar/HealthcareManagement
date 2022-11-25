package com.healthcare.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthcare.dao.DoctorDAO;
import com.healthcare.util.ConnectionProvider;

@WebServlet("/deleteDoctor")
public class DeleteDoctor extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		DoctorDAO doctorDao=new DoctorDAO(ConnectionProvider.getconnection());
		
		HttpSession session=req.getSession();
		
		if (doctorDao.DeleteDoctor(id)) {
			session.setAttribute("succMsg", "Doctor Delete Sucessfully..");
			resp.sendRedirect("admin/View_doctor.jsp");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
			resp.sendRedirect("admin/View_doctor.jsp");
		
		}
	

	
	}
}
