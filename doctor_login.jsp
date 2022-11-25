<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width = device-width, initial-scale = 1.0">
<title>doctor_login</title>
<%@include file="component/allcss.jsp"%>
<link href="admin.css" rel="stylesheet">
<style>
.navbar {
	height: 49px;
}
</style>
</head>

<body style="background: linear-gradient(#ffff, #e2b9f9)">

	<%@include file="component/navbar.jsp"%>

	<div class="wrapper">
		<header style="color: #9F44D3">Doctor Login </header>

		<c:if test="${not empty succMsg }">
			<p class="text-center text-success fs-3">${succMsg}</p>
			<c:remove var="succMsg" scope="session" />
		</c:if>

		<c:if test="${not empty errorMsg }">
			<p class="text-center text-danger fs-5">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>

		<form action="doctorLogin" method="post">

			<div class="field email">
				<div class="input-area">
					<input required name="email" type="text"
						placeholder="Email Address"> <i
						class="icon fas fa-envelope"></i> <i
						class="error error-icon fas fa-exclamation-circle"></i>
				</div>
			</div>

			<div class="field password">
				<div class="input-area">
					<input required name="password" type="password"
						placeholder="Password"> <i class="icon fas fa-lock"></i> <i
						class="error error-icon fas fa-exclamation-circle"></i>
				</div>
			</div>

			<div class="pass-txt">
				<a href="edit_Profile.jsp">Forgot password?</a>
			</div>

			<div class="button">
				<input type="submit" value="Login">
			</div>

		</form>
	</div>
	<!--  -->
</body>
</html>