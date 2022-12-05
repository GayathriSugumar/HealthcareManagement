package com.healthcare.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UserOtp")
public class UservalidateOtp extends HttpServlet {


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int value = Integer.parseInt(request.getParameter("otp"));
		System.out.println("User otp:"+value);//user otp
		
		HttpSession session = request.getSession();
		
		int otp = (int) session.getAttribute("otp");//generated otp in mail
		

		RequestDispatcher dispatcher = null;

		if (value == otp) {

			request.setAttribute("email", request.getParameter("email"));
			System.out.println("OTP validation email "+request.getParameter("email"));
			
			request.setAttribute("status", "success");
			dispatcher = request.getRequestDispatcher("UserChangePassword.jsp");
			dispatcher.forward(request, response);

		} else {
			request.setAttribute("message", "wrong otp");

			dispatcher = request.getRequestDispatcher("OTP.jsp");
			dispatcher.forward(request, response);

		}

	}
	}


