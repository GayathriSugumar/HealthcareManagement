<%@page import="com.healthcare.dto.DoctorEntity"%>
<%@page import="com.healthcare.dto.AppointmentEntity"%>
<%@page import="com.healthcare.dao.AppointmentDAO"%>
<%@page import="java.util.List"%>
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
<title>Doctor DashBoard</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.navbar{
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
</style>
<%
response.setHeader("Pragma", "no-cache");

response.setHeader("Cache-Control", "no-store");

response.setHeader("Expires", "0");

response.setDateHeader("Expires", -1);
%>
</head>
<body>
	<c:if test="${empty doctorObj }">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>

	<%@include file="navbar.jsp"%>
	
	<div class="container p-3 mt-5">
		<div class="row">

			<div class="col-md-12 mt-5">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center text-primary">Patient Details</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-4 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<p class=" fs-4 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appointment Date</th>
									<th scope="col">Mobile</th>
									<th scope="col">Illness</th>
									<th scope="col">Status</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								DoctorEntity doctor =(DoctorEntity) session.getAttribute("doctorObj");
								AppointmentDAO appointmentDao = new AppointmentDAO(ConnectionProvider.getconnection());
								List<AppointmentEntity> list = appointmentDao.getAllAppointmentsByDoctorId(doctor.getId());
								for (AppointmentEntity appointment : list) {
								%>
								<tr>
									<th><%=appointment.getFullName()%></th>
									<td><%=appointment.getGender()%></td>
									<td><%=appointment.getAge()%></td>
									<td><%=appointment.getAppointmentDate()%></td>
									
									<td><%=appointment.getMobile() %></td>
									<td><%=appointment.getIllness() %></td>
									<td><%=appointment.getStatus() %></td>
									
									<td>
										 
										 <a href="comment.jsp?id=<%=appointment.getId() %>" class="btn btn-success btn-sm">Comment</a> 
										 
									</td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>