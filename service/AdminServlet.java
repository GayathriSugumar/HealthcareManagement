package com.healthcare.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthcare.dao.AdminDAOImpl;
import com.healthcare.dto.AdminEntity;
import com.healthcare.util.ConnectionProvider;

@WebServlet("/adminlogin")
public class AdminServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			AdminEntity adminEntity = new AdminEntity(email, password);

			AdminDAOImpl adminDAO = new AdminDAOImpl(ConnectionProvider.getconnection());

			boolean result = adminDAO.AdminSaveEntity(adminEntity);

			HttpSession session = req.getSession();

			if ("admin@gmail.com".equals(email) && "admin".equals(password)) {

				session.setAttribute("adminObj",new AdminEntity());
				resp.sendRedirect("admin/index.jsp");
				System.out.println("Login Susseccfully!");
			} else {
				session.setAttribute("errorMsg", "Somthing went wrong!Try again");
				resp.sendRedirect("admin_login.jsp");
				System.out.println("Somthing went wrong!Try again");
			}
		} catch (Exception e) {

		}

	}
}
