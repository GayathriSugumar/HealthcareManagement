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
<title>Home Page</title>
<%@include file="component/allcss.jsp"%>
<link href="indexnav.css" rel="stylesheet">
<link href="admin.css" rel="stylesheet">
<style>
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

body {
	background: linear-gradient(#ffff, #dda3ff);
}

button {
	background: linear-gradient(135deg, #da83ff, #9f01ea);
}
</style>
</head>
<body style="margin-top: 50px;">
	<%@include file="component/navbar.jsp"%>

	<c:if test="${ empty userObj }">
		<c:redirect url="user_login.jsp"></c:redirect>
	</c:if>

	<div class="wrapper" style="background: #ffff">
		<header>Change Password </header>
		<c:if test="${not empty succMsg }">
			<p class="text-center text-success fs-3">${succMsg}</p>
			<c:remove var="succMsg" scope="session" />
		</c:if>

		<c:if test="${not empty errorMsg }">
			<p class="text-center text-danger fs-5">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>

		<form action="userChangePassword" method="post">

			<div class="field password">
				<div class="input-area">
					<input type="Password" placeholder="newPassword" name="newPassword"
						required> <i class="icon fas fa-lock"></i> <i
						class="error error-icon fas fa-exclamation-circle"></i>
				</div>
			</div>

			<div class="field password">
				<div class="input-area">
					<input type="Password" placeholder="oldPassword" name="oldPassword"
						required> <i class="icon fas fa-lock"></i> <i
						class="error error-icon fas fa-exclamation-circle"></i>
				</div>
			</div>

			<div class="button">
				<input type="hidden" value="${userObj.id }" name="userId"> <input
					type="submit" class="btn" value="Change Password">
				<!--  <div class="button">
				<<input type="submit" value="Login">-->
			</div>
		</form>
	</div>
</body>
</html>