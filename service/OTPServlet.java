package com.healthcare.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthcare.dao.PaymentDAO;
import com.healthcare.dto.PaymentEntity;
import com.healthcare.util.ConnectionProvider;

@WebServlet("/OTPverify")
public class OTPServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("generatedOtp" + req.getSession().getAttribute("generatedOtp"));

		String otp = req.getParameter("otp"); // user entered otp
		String generatedOtp = (String) req.getSession().getAttribute("generatedOtp");
		System.out.println("ser entered otp" + otp);
		// PaymentDAO paymentDao = new PaymentDAO(ConnectionProvider.getconnection());
		HttpSession session = req.getSession();
//		PaymentEntity payment=(PaymentEntity)req.getSession().getAttribute(otp);

		if (otp.equals(generatedOtp)) {

			session.setAttribute("succMsg", "OTP verify Sucessfully..");
			resp.sendRedirect("view_appointment.jsp");
			System.out.println("Appointment Booked successfully");

		} else {
			session.setAttribute("errorMsg", "something wrong on server");
			resp.sendRedirect("user_appointment.jsp");
			System.out.println("something wrong !..Appointment not Booked");

		}
	}

	/*
	 * private PaymentEntity PaymentEntity(Object attribute) {
	 * 
	 * return null; }
	 */
}
