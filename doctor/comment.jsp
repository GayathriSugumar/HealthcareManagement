<%@page import="com.healthcare.dto.AppointmentEntity"%>
<%@page import="com.healthcare.dao.AppointmentDAO"%>
<%@page import="com.healthcare.util.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name = "viewport" content = "width = device-width, initial-scale = 1.0">
<title>Doctor Dash Board</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.navbar {
	height: 49px;
}

body {
	background: url(../image/user7.jpeg) no-repeat center center fixed;
	/*  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover; */
	background-size: cover;
	
}

.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

.btn {
	background: #9F44D3;
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

	
	<div class="container p-3">
		<div class="row">
		<div class="col-md-6 p-5"></div>
			<div class="col-md-6 ">
				<div class="card paint-card">
					<div class="card-body mb-2">
						<p class="text-center fs-4 " style="color: #9F44D3">Patient
							Comment</p>

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						AppointmentDAO appointmentDao = new AppointmentDAO(ConnectionProvider.getconnection());

						AppointmentEntity appointment = appointmentDao.getAllAppointmentsById(id);
						%>
						<form class="row" action="../updateStatus" method="post">
							<div class="col-md-6">
								<label>Patient Name</label> <input type="text" readonly
									value="<%=appointment.getFullName()%>" class="form-control">
							</div>

							<div class="col-md-6">
								<label>Age</label> <input type="text"
									value="<%=appointment.getAge()%>" readonly class="form-control">
							</div>


							<div class="col-md-6">
								<br> <label>Mob No</label> <input type="text" readonly
									value="<%=appointment.getMobile()%>" class="form-control">
							</div>

							<div class="col-md-6">
								<br> <label>Diseases</label> <input type="text" readonly
									value="<%=appointment.getIllness()%>" class="form-control">
							</div>

							<div class="col-md-12">
								<br> <label>Comment</label>
								<textarea required name="comment" class="form-control" row="3"
									cols=""></textarea>
							</div>
							<div>
								<input type="hidden" name="id" value="<%=appointment.getId()%>">
								<input type="hidden" name="doctorId"
									value="<%=appointment.getDoctorId()%>">
							</div>

							<input class="btn mt-3" type="submit" value="submit" />
							<!-- <div>
								<button class="btn" type="submit">Submit</button>
							</div> -->

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>