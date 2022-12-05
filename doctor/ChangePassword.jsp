<%@page import="java.util.List"%>
<%@page import="com.healthcare.util.ConnectionProvider"%>
<%@page import="com.healthcare.dto.SpecialistEntity"%>
<%@page import="com.healthcare.dao.SpecialistDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width = device-width, initial-scale = 1.0">
<title>Doctor Change Password</title>
<%@include file="../component/allcss.jsp"%>
<link href="admin.css" rel="stylesheet">
<style type="text/css">
.navbar {
	height: 49px;
}

.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

body {
	background: linear-gradient(#ffff, #dda3ff);
	background: cover;
}

.btn {
	height: 100%;
	width: 100%;
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
<body style="margin-top: 210px; margin-bottom: 100px;">
	<%-- <c:if test="${empty doctorObj }">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if> --%>

	<%@include file="navbar.jsp"%>

	<div class="container p-4 ">
		<div class="row">
			<div class="col-4"></div>
			<div class="col-md-4">
				<div class="card paint-card mb-4">
					<p class="text-center fs-3 " style="color: #9F44D3">
					Forgot Password</p>
		
					<div class="card-body">

						<form action="../docterPassword" method="post">
							<!-- <div class="mb-3"> -->

							<div class="mb-3">
								<label>Enter Email-Id</label> <input type="text" name="email"
									class="form-control" required>
							</div>

							<input type="hidden" value="${doctorObj.id }" name="userId">
							<input type="submit" class="btn btn-primary" value="Countinue">

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

<!-- <div class="mb-3">
									<label>Enter Old Password</label> <input type="text"
										name="oldPassword" class="form-control">
								</div>

								<label>Enter New Password</label> <input type="text"
									name="newPassword" class="form-control" required>
							</div>

							<div class="mb-3">
								<label>Enter Confirm Password</label> <input type="text"
									name="confirmPassword" class="form-control" required>
							</div>
							
 -->