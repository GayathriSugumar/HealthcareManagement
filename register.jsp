<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Register</title>
<%@include file="component/allcss.jsp"%>

<link href="admin.css" rel="stylesheet">
<style type="text/css">
body {
	background: url(image/login5.png) no-repeat center center fixed;
	/*  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover; 
  style="background: linear-gradient(#ffff, #dda3ff)"
  style="background: linear-gradient(#ffff, #dda3ff)"*/
	background-size: cover;
	
}
</style>
<%
response.setHeader("Pragma", "no-cache");

response.setHeader("Cache-Control", "no-store");

response.setHeader("Expires", "0");

response.setDateHeader("Expires", -1);
%>
</head>
<body>
	<%@include file="component/navbar.jsp"%>


	<div class="wrapper mt-5" style="background: #ffff">
		<header style="color: #9F44D3">User Registration</header>
		<c:if test="${not empty success }">
			<p class="text-center text-primary fs-6">${success}</p>
			<c:remove var="success" scope="session" />
		</c:if>

		<c:if test="${not empty error }">
			<p class="text-center text-primary fs-6">${error}</p>
			<c:remove var="error" scope="session" />
		</c:if>

		<form action="UserResgister" method="post">

			<div class="field FullName">
				<div class="input-area">
					<input required type="text" placeholder="Full Name" name="fullName">
					<i class="icon fa-solid fa-user"></i> <i
						class="error error-icon fas fa-exclamation-circle"></i>
				</div>
				<div class="error error-txt">Username can't be blank</div>
			</div>

			<div class="field email">
				<div class="input-area">
					<input type="text" placeholder="Email Address" name="email">
					<i class="icon fas fa-envelope"></i> <i
						class="error error-icon fas fa-exclamation-circle"></i>
				</div>
				<div class="error error-txt">Email can't be blank</div>
			</div>

			<div class="field password">
				<div class="input-area">
					<input type="password" placeholder="Password" name="password">
					<i class="icon fas fa-lock"></i> <i
						class="error error-icon fas fa-exclamation-circle"></i>
				</div>
				<div class="error error-txt">Password can't be blank</div>
			</div>


			<div class="button">
				<input type="submit" value="Register" />
			</div>


		</form>
	</div>

</body>
</html>