<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width = device-width, initial-scale = 1.0">
<title>User Forgot Password </title>
<%@include file="component/allcss.jsp"%>
<link href="indexnav.css" rel="stylesheet">
<link href="admin.css" rel="stylesheet">
<style>
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

body {
	background: linear-gradient(#ffff, #dda3ff);
	background: cover;
}

button {
	background: linear-gradient(135deg, #da83ff, #9f01ea);
}
</style>
<%
response.setHeader("Pragma", "no-cache");

response.setHeader("Cache-Control", "no-store");

response.setHeader("Expires", "0");

response.setDateHeader("Expires", -1);
%>
</head>
<body style="margin-top: 50px;">

	<%@include file="component/navbar.jsp"%>
	<div class="wrapper">
		<header style="color: #9F44D3">Forgot Password </header>

		<form action="userChangePassword" method="post">

			<div class="field password">
				<div class="input-area">
				
					<input type="email" placeholder="Enter Email" name="email" required>
					<i class="icon fas fa-envelope"></i> <i
						class="error error-icon fas fa-exclamation-circle"></i>
				</div>
			</div>
			
			<div class="button">
				<input type="hidden" value="${userObj.id }" name="userId"> <input
					type="submit" class="btn" value="Generate OTP">

			</div>
		</form>
	</div>


</body>
</html>

