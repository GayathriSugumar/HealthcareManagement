package com.healthcare.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthcare.dao.UserDAO;
import com.healthcare.util.ConnectionProvider;

@WebServlet("/userChangePassword")
public class ChangePasswordServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int userId=Integer.parseInt(req.getParameter("userId"));
		String oldPassword=req.getParameter("oldPassword");
		String newPassword=req.getParameter("newPassword");
		
		UserDAO userDao=new UserDAO(ConnectionProvider.getconnection());
		HttpSession session=req.getSession();
		
		if (userDao.ChangePassword(userId, oldPassword)) 
		{
			if (userDao.saveNewPassword(userId, newPassword)) {
				session.setAttribute("succMsg", "Password Change Sucessfully");
				resp.sendRedirect("changePassword.jsp");
				System.out.println("Password changed Successfully");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("changePassword.jsp");
				System.out.println("Password has not not been changed");
			}
			
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
			resp.sendRedirect("changePassword.jsp");
			System.out.println("Password has not not been changed");
		}
	}
	
	

}
