package com.healthcare.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthcare.dao.PaymentDAO;
import com.healthcare.dto.PaymentEntity;
import com.healthcare.util.ConnectionProvider;

@WebServlet("/Payment")
public class PaymentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");

		String otp = req.getParameter("otp");

		String appointmentFees = req.getParameter("appointmentFees");
		
		PaymentDAO paymentDao = new PaymentDAO(ConnectionProvider.getconnection());
		
		otp=paymentDao.generateOTP();


		HttpSession session = req.getSession();

		if (paymentDao.SendEmailtoUser(email, otp)) {
			
			
			//servlet to servlet passing values
			req.getSession().setAttribute("generatedOtp", otp);
			req.getRequestDispatcher("OtpVerification.jsp").forward(req, resp);
			
			session.setAttribute("succMsg", "OTP send Sucessfully..");
			//resp.sendRedirect("OtpVerification.jsp");
			System.out.println("Otp send to useremail successfully");
			
//			PaymentEntity payment = new PaymentEntity(email, otp, "1000");
			
			/*
			 * if (paymentDao.SavePayement(payment)) { session.setAttribute("succMsg",
			 * "Payment Details saved successfully..");
			 * resp.sendRedirect("OtpVerification.jsp");
			 * System.out.println("Otp send to useremail successfully"); }
			 */ /*
				 * else { session.setAttribute("errorMsg",
				 * "something wrong Payment details not saved"); session.
				 * resp.sendRedirect("user_appointment.jsp");
				 * System.out.println("something wrong !..Appointment not Booked"); }
				 */

		} else {
			session.setAttribute("errorMsg", "something wrong on server otp is not send");
			resp.sendRedirect("user_appointment.jsp");
			System.out.println("something wrong !..Appointment not Booked");

		}

	}

}
