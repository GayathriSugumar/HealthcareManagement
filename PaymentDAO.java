package com.healthcare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.tomcat.util.file.Matcher;

import com.healthcare.dto.PaymentEntity;

public class PaymentDAO {

	private Connection connection;
	private String otp;

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public PaymentDAO(Connection connection) {
		super();
		this.connection = connection;
		System.out.println("Invoked PaymentDAO");
	}

	public static String generateOTP() {
		int random = (int) (Math.random() * 9000) + 1000;
		String otp = String.valueOf(random);
		return otp;
	}

	public boolean SendEmailtoUser(String email, String otp) {
		System.out.println("Invoked SendEmailtoUser");
		boolean success = false;
		try {

			List<InternetAddress> inetAddressList = new ArrayList<InternetAddress>();
			// PaymentEntity payment=new PaymentEntity();
			inetAddressList.add(new InternetAddress(email)); // Receive mail

			InternetAddress[] recipientAddress = new InternetAddress[inetAddressList.size()];
			recipientAddress = inetAddressList.toArray(recipientAddress);

			String fromUser = "lilachealthcare24@gmail.com";

			if (recipientAddress != null && recipientAddress.length > 0) {

				Properties emailProps = new Properties();

				emailProps.put("mail.smtp.host", "smtp.gmail.com");// "smtp.gmail.com"
				emailProps.put("mail.smtp.port", "587");// "587"
				emailProps.put("mail.smtp.ssl.trust", "smtp.gmail.com");
				final String smtpUserName = "lilachealthcare24@gmail.com";
				final String smtpPassword = "hqqskjjmqvocqrfn";

				Session session1 = null;
				if (smtpUserName != null && smtpUserName.trim().length() > 0 && smtpPassword != null
						&& smtpPassword.trim().length() > 0) {
					emailProps.put("mail.smtp.starttls.enable", "true");
					emailProps.put("mail.smtp.auth", "true");
					emailProps.put("mail.debug", "false");
					emailProps.put("mail.smtp.socketFactory.fallback", "false");

					session1 = Session.getDefaultInstance(emailProps, new Authenticator() {
						// override the getPasswordAuthentication method
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(smtpUserName, smtpPassword);
						}
					});
				} else {

					emailProps.put("mail.smtp.auth", "false");
					emailProps.put("mail.smtp.starttls.enable", "true");
					session1 = Session.getDefaultInstance(emailProps);
				}

				javax.mail.Message mimeMessage = new MimeMessage(session1);
				mimeMessage.addRecipients(Message.RecipientType.TO, recipientAddress);
				mimeMessage.setSubject("OTP Verification");
				Random random = new Random();
				/*
				 * int pin = random.nextInt(10000); otp =String.valueOf(pin);
				 */
				mimeMessage.setText("Welcome to Lilac Healthcare Online Booking" + "\n" + otp
						+ " -Your verification code Don't share with others");
				mimeMessage.setFrom(new InternetAddress(fromUser));

				mimeMessage.setSentDate(new Date());
				Transport.send(mimeMessage);
				success = true;
				System.out.println("OTP Generated Successfully " + otp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		return success;

	}

	public boolean SavePayement(PaymentEntity payment) {
		System.out.println("Invoked SavePayement" + payment.getOtp());

		boolean flag = false;

		try {
			String sqlStatement = "insert into payment(email,otp,appointmentFees) values(?,?,?)";
			PreparedStatement prepareStatement = connection.prepareStatement(sqlStatement);

			prepareStatement.setString(1, payment.getEmail());
			prepareStatement.setString(2, payment.getOtp());
			System.out.println(payment.getOtp());
			prepareStatement.setString(3, payment.getAppointmentFees());

			// while
			System.out.println("OTP saved into Database Succssfully!...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

}
