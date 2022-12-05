package com.healthcare.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthcare.dao.AdminDAOImpl;
import com.healthcare.dao.UserDAO;
import com.healthcare.dto.AdminEntity;
import com.healthcare.dto.UserEntity;
import com.healthcare.util.ConnectionProvider;

@WebServlet("/userLogin")
public class UserLogin extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			HttpSession session = req.getSession();

			UserDAO userDao=new UserDAO(ConnectionProvider.getconnection());
			UserEntity user=userDao.ValidateUserLogin(email, password);
			System.out.println(email);
			System.out.println(password);
			
			if (user!=null) {

				session.setAttribute("userObj",user);
				resp.sendRedirect("index.jsp");

				System.out.println("Login Susseccfully!");
			} else {
				session.setAttribute("error", "Somthing went wrong!Try again");
				resp.sendRedirect("user_login.jsp");
				System.out.println("Somthing went wrong!Try again");
			}
		} catch (Exception e) {

		}

	}
}
