package com.healthcare.doctorServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthcare.dao.DoctorDAO;
import com.healthcare.dto.DoctorEntity;
import com.healthcare.dto.UserEntity;
import com.healthcare.util.ConnectionProvider;

@WebServlet("/doctorLogin")
public class DoctorLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			HttpSession session = req.getSession();
			
			DoctorDAO doctorDao=new DoctorDAO(ConnectionProvider.getconnection());
			
			DoctorEntity doctor=doctorDao.Login(email, password);
			
			if (doctor!=null) {

				session.setAttribute("doctorObj",doctor);
				resp.sendRedirect("doctor/index.jsp");

				System.out.println("Login Susseccfully!");
			} else {
				session.setAttribute("error", "Somthing went wrong!Try again");
				resp.sendRedirect("doctor_login.jsp");
				System.out.println("Somthing went wrong!Try again");
			}
		} catch (Exception e) {

		}

	}

}
