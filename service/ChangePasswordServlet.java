package com.healthcare.service;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
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

import com.healthcare.dao.UserDAO;
import com.healthcare.util.ConnectionProvider;

@WebServlet("/userChangePassword")
public class ChangePasswordServlet extends HttpServlet {

	@SuppressWarnings("null")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");

		RequestDispatcher dispatcher = null;
		HttpSession session = req.getSession();
		int otp = 0;
		if (email != null || !email.equals("")) {
			System.out.println("Invoked UserEmail Servlet");
			Random random = new Random();
			otp = random.nextInt(10000);
			String to = email;

			Properties properties = new Properties();
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.socketFactory.port", "465");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			properties.put("mail.smtp.port", "465");
			properties.put("mail.smtp.socketFactory.fallback", "false");
			Session session1 = Session.getDefaultInstance(properties, new Authenticator() {
				// override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("lilachealthcare24@gmail.com", "hqqskjjmqvocqrfn");
				}

			});
			try {
				MimeMessage mimeMessage = new MimeMessage(session1);
				mimeMessage.setFrom(new InternetAddress(email));
				mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				mimeMessage.setSubject("OTP Verification");
				mimeMessage.setText("Welcome to Lilac Healthcare Online Booking" + "\n" + otp
						+ " -Your verification code Don't share with others");
				Transport.send(mimeMessage);
				System.out.println("OTP send successfully" + otp);
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			dispatcher = req.getRequestDispatcher("OTP.jsp");
			req.setAttribute("message","OTP is sent to your email id");
			
			//request.setAttribute("connection", con);
			session.setAttribute("otp",otp); 
			session.setAttribute("email",email); 
			dispatcher.forward(req, resp);
			//request.setAttribute("status", "success");
		
		
	}
	}

	}

