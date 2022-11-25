package com.healthcare.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthcare.dao.AppointmentDAO;
import com.healthcare.util.ConnectionProvider;

@WebServlet("/updateStatus")
public class UpdateStatusServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int id=Integer.parseInt(req.getParameter("id"));
			int doctorId=Integer.parseInt(req.getParameter("doctorId"));
			String comment=req.getParameter("comment");
			
			AppointmentDAO appointmentDao = new AppointmentDAO(ConnectionProvider.getconnection());
			
			HttpSession session = req.getSession();
			
			if (appointmentDao.updateStatusComment(id, doctorId, comment)) {
				session.setAttribute("succMsg", "Comment Updated Sucessfully..");
				resp.sendRedirect("doctor/patient.jsp");
				System.out.println("Appointment Booked successfully");
				
			} else {
				session.setAttribute("errorMsg", "something wrong on server!Comment not updated..");
				resp.sendRedirect("doctor/patient.jsp");
				System.out.println("something wrong !..Appointment not Booked");

			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
