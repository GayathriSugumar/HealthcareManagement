package com.healthcare.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userLogout")
public class UserLogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		session.removeAttribute("userObj");
		session.setAttribute("succMsg", "User Logout successfully!");
		if (session == null || session.getAttribute("username") == null) {
			resp.sendRedirect("index.jsp"); // No logged-in user found, so redirect to login page.
		} else {
			resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
			resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
			resp.setDateHeader("Expires", 0);

		}

		System.out.println("UserLogout successfully");

	}

}
