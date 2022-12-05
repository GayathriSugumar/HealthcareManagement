<%@page import="com.healthcare.util.ConnectionProvider"%>
<%@page import="com.healthcare.dao.DoctorDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name = "viewport" content = "width = device-width, initial-scale = 1.0">
<title>AdminPanel</title>
<%@include file="../component/allcss.jsp"%>
<link href="Nav.css" rel="stylesheet">
<style type="text/css">
.navbar{
	height: 49px;
	
}
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
<%
response.setHeader("Pragma","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Expires","0");
response.setDateHeader("Expires",-1);

%>
</head>
<body>
	<%@include file="navbar.jsp"%>


	<c:if test="${ empty adminObj }">
		<c:redirect url="../admin_login.jsp"></c:redirect>
	</c:if>

	<div class="container p-5 mt-5">
		<p class="text-center fs-3 text-primary text-bold">Admin Dashboard</p>
		<c:if test="${not empty errorMsg}">
			<p class="fs-3 text-center text-danger">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>
		<c:if test="${not empty succMsg}">
			<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
			<c:remove var="succMsg" scope="session" />
		</c:if>
		<%
		DoctorDAO doctorDao = new DoctorDAO(ConnectionProvider.getconnection());
		%>
		<div class="row">
				<div class="col-md-4 mb-4">
					<div class="card paint-card">
						<div class="card-body text-center text-primary">
							<i class="fas fa-user-md fa-3x"></i><br>
							<p class="fs-4 text-center">
								<a href="doctor.jsp">Doctor</a> <br><%=doctorDao.countDoctor() %>
							</p>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="card paint-card">
						<div class="card-body text-center text-primary">
							<i class="fas fa-user-circle fa-3x"></i><br>
							<p class="fs-4 text-center">
								<a href="../user_login.jsp">User</a> <br><%=doctorDao.countUser() %>
							</p>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="card paint-card">
						<div class="card-body text-center text-primary">
							<i class="far fa-calendar-check fa-3x"></i><br>
							<p class="fs-4 text-center">
								<a href="patient.jsp">Total Appointment </a><br><%=doctorDao.countAppointment()%>
							</p>
						</div>
					</div>
				</div>

				<div class="col-md-4">

					<div class="card paint-card " data-bs-toggle="modal"
						data-bs-target="#exampleModal">
						<div class="card-body text-center text-primary">
							<i class="far fa-calendar-check fa-3x"></i><br>
							<p class="fs-4 text-center">
								Specialist <br><%=doctorDao.countSpecialist() %>
							</p>
						</div>
					</div>

				</div>

			</div>
		</div>



		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form action="../addSpecialist" method="post">

							<div class="form-group">
								<label>Enter Specialist Name</label> <input type="text"
									name="specialistName" class="form-control">
							</div>
							<div class="text-center mt-3">
								<button type="submit" class="btn btn-primary">Add</button>
							</div>

						</form>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>

					</div>
				</div>
			</div>
		</div>
</body>
</html>


