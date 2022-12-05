package com.healthcare.doctorServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ValidateOtp")
public class ValidateOtp extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int value = Integer.parseInt(request.getParameter("otp"));
		System.out.println("User otp:"+value);
		HttpSession session = request.getSession();
		int otp = (int) session.getAttribute("otp");
		System.out.println("Db Otp"+otp);

		RequestDispatcher dispatcher = null;

		if (value == otp) {

			request.setAttribute("email", request.getParameter("email"));
			System.out.println("OTP validation email "+request.getParameter("email"));
			
			request.setAttribute("status", "success");
			dispatcher = request.getRequestDispatcher("doctor/newPassword.jsp");
			dispatcher.forward(request, response);

		} else {
			request.setAttribute("message", "wrong otp");

			dispatcher = request.getRequestDispatcher("doctor/ValidateOtp.jsp");
			dispatcher.forward(request, response);

		}

	}

}
