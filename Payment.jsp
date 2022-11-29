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
<title>Insert title here></title>
<%@include file="component/allcss.jsp"%>
<link href="admin.css" rel="stylesheet">
<style>
.navbar {
	height: 49px;
}
</style>
</head>
<body style="background: linear-gradient(#ffff, #dda3ff)">
	<%@include file="component/navbar.jsp"%>

	<div class="wrapper">
		<header style="color: #9F44D3">Payment </header>

		<c:if test="${not empty succMsg }">
			<p class="text-center text-success fs-3">${succMsg}</p>
			<c:remove var="succMsg" scope="session" />
		</c:if>

		<c:if test="${not empty errorMsg }">
			<p class="text-center text-danger fs-5">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>

		<form action="Payment" method="post">

			<div class="field email">
				<div class="input-area">
					<input required name="email" type="text"
						placeholder="Email Address" pattern="[^ @]*@[^ @]*"> <i
						class="icon fas fa-envelope"></i> <i
						class="error error-icon fas fa-exclamation-circle"></i>
				</div>
			</div>

			<div class="field password">
				<div class="input-area">
					<input required name="appointmentFees" type="text"
						 readonly value="Rs.1000"> 1000<i class="icon fas fa-lock"></i> <i
						class="error error-icon fas fa-exclamation-circle"></i>
				</div>
			</div>

			

			<div class="button">
				<input type="submit" value="Continue">
			</div>

		</form>
	</div>
</body>
</html>
