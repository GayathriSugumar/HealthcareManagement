package com.healthcare.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthcare.dao.AppointmentDAO;
import com.healthcare.dto.AppointmentEntity;
import com.healthcare.util.ConnectionProvider;

@WebServlet("/appAppointment")
public class AppointmentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int userId = Integer.parseInt(req.getParameter("userId"));
		String fullName = req.getParameter("fullName");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String appointmentDate = req.getParameter("appointmentDate");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String illness = req.getParameter("illness");
		int doctorId = Integer.parseInt(req.getParameter("doctorId"));
		String address = req.getParameter("address");
		String status = req.getParameter("status");

		AppointmentEntity appointment = new AppointmentEntity(userId, fullName, gender, age, appointmentDate, email,
				mobile, illness, doctorId, address, "Pending");
		AppointmentDAO appointmentDao = new AppointmentDAO(ConnectionProvider.getconnection());
		HttpSession session = req.getSession();

		if (appointmentDao.addAppointment(appointment)) {
			session.setAttribute("succMsg", "Appointment Booked Sucessfully..");
			resp.sendRedirect("user_appointment.jsp");
			System.out.println("Appointment Booked successfully");

		} else {
			session.setAttribute("errorMsg", "something wrong on server");
			resp.sendRedirect("user_appointment.jsp");
			System.out.println("something wrong !..Appointment not Booked");

		}
	}

}
