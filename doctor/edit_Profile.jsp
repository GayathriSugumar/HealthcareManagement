<%@page import="java.util.List"%>
<%@page import="com.healthcare.util.ConnectionProvider"%>
<%@page import="com.healthcare.dto.SpecialistEntity"%>
<%@page import="com.healthcare.dao.SpecialistDAO"%>
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
<title>doctor panel</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.navbar {
	height: 49px;
}

.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

body {
	background: linear-gradient(#ffff, #dda3ff);
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
<body style="margin-top: 50px;">
	<c:if test="${empty doctorObj }">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>

	<%@include file="navbar.jsp"%>

	<div class="container p-4">
		<div class="row">
			<%-- <div class="col-md-4">
				<div class="card paint-card">
					<p class="text-center fs-3 " style="color: #9F44D3">Change Password</p>
					<c:if test="${not empty succMsgd }">
						<p class="text-center text-success fs-3">${succMsgd}</p>
						<c:remove var="succMsgd" scope="session" />
					</c:if>

					<c:if test="${not empty errorMsgd }">
						<p class="text-center text-danger fs-5">${errorMsgd}</p>
						<c:remove var="errorMsgd" scope="session" />
					</c:if>
					
					<div class="card-body">

						<form action="../docterPassword" method="post">
							<div class="mb-3">
							
							<div class="mb-3">
								<label>Enter Old Password</label> <input type="text"
									name="oldPassword" class="form-control" required>
							</div>

								<label>Enter New Password</label> <input type="text"
									name="newPassword" class="form-control" required>
							</div>

							<div class="mb-3">
								<label>Enter Confirm Password</label> <input type="text"
									 class="form-control" required>
							</div>

							<input type="hidden" value="${doctorObj.id }" name="userId">
							<input type="submit" class="btn btn-primary" value="Change Password">

						</form>
					</div>
				</div>
			</div>
 --%>
			<div class="container p-4">
				<div class="row">
				<div class="col-2"></div>
					<div class="col-md-5 offset-md-2">
						<div class="card paint-card ">
							<div class="card-body">
								<form action="../doctorEditProfile" method="post">
									<p class="text-center fs-3 " style="color: #9F44D3">Edit Profile
										</p>
									<c:if test="${not empty succMsgd }">
										<p class="text-center text-success fs-3">${succMsgd}</p>
										<c:remove var="succMsgd" scope="session" />
									</c:if>

									<c:if test="${not empty errorMsgd }">
										<p class="text-center text-danger fs-5">${errorMsgd}</p>
										<c:remove var="errorMsgd" scope="session" />
									</c:if>

									<div class="mb-3">
										<label class="form-label">Full Name</label> <input type="text"
											required name="fullName" class="form-control"
											value="${doctorObj.fullName}">
									</div>

									<div class="mb-3">
										<label class="form-label">DOB</label> <input type="date"
											required name="dob" class="form-control"
											value="${doctorObj.dob}">
									</div>

									<div class="mb-3">
										<label class="form-label">Qualification</label> <input
											required name="qualification" type="text"
											class="form-control" value="${doctorObj.qualification}">
									</div>
									<div class="mb-3">
										<label class="form-label">Specialist</label> <select
											name="specialistName" required class="form-control">
											<option>${doctorObj.specialistName}</option>

											<%
											SpecialistDAO specialistDao = new SpecialistDAO(ConnectionProvider.getconnection());
											List<SpecialistEntity> list = specialistDao.getAllSpecialist();
											for (SpecialistEntity specialist : list) {
											%>
											<option><%=specialist.getSpecialistName()%></option>
											<%
											}
											%>

										</select>
									</div>

									<div class="mb-3">
										<label class="form-label">Email</label> <input type="text"
											readOnly name="email" class="form-control"
											value="${doctorObj.email}">
									</div>

									<div class="mb-3">
										<label class="form-label">Mobile</label> <input type="text"
											required name="mobile" class="form-control"
											value="${doctorObj.mobile}"> <input type="hidden"
											name="id" value="${doctorObj.id }">
									</div>
									<button type="submit" class="btn btn-primary">Submit</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>