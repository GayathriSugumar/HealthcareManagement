<%@page import="com.healthcare.dto.DoctorEntity"%>
<%@page import="com.healthcare.dao.DoctorDAO"%>
<%@page import="com.healthcare.dto.AppointmentEntity"%>
<%@page import="com.healthcare.dao.AppointmentDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.healthcare.util.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin DashBoard</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.navbar{
	height: 49px;
	
}
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

.form-label {
	font-size: 14px;
}

.table {
	font-size: 14px;
}

.table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
	background-color: #ecdcf5;
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
	<%@include file="navbar.jsp"%>

	<div class="container-fluid p-3 mt-5">
		<div class="row">

			<div class="col-md-12 mt-5">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-5 text-center text-primary">Patient Details</p>
						<div class="table-responsive">
							<table class="table table-hover ">
								<thead>
									<tr>
										<th scope="col">Full Name</th>
										<th scope="col">Gender</th>
										<th scope="col">Age</th>
										<th scope="col">Appointment Date</th>
										<th scope="col">Email</th>
										<th scope="col">Mobile</th>
										<th scope="col">Illness</th>
										<th scope="col">Doctor Name</th>
										<th scope="col">Address</th>
										<th scope="col">Status</th>
									</tr>
								</thead>
								<tbody>
									<%
									AppointmentDAO appointmentDao = new AppointmentDAO(ConnectionProvider.getconnection());

									DoctorDAO doctorDao = new DoctorDAO(ConnectionProvider.getconnection());

									List<AppointmentEntity> list = appointmentDao.getAllAppointments();

									for (AppointmentEntity appointment : list) {
										DoctorEntity doctor = doctorDao.getDoctorById(appointment.getDoctorId());
									%>
									<tr>
										<th><%=appointment.getFullName()%></th>
										<td><%=appointment.getGender()%></td>
										<td><%=appointment.getAge()%></td>
										<td><%=appointment.getAppointmentDate()%></td>
										<%-- <td><%=appointment.getEmail()%></td> --%>
										<td><%=appointment.getMobile()%></td>
										<td><%=appointment.getIllness()%></td>
										<td><%=doctor.getFullName()%></td>
										<td><%=appointment.getAddress()%></td>
										<td><%=appointment.getStatus()%></td>

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
	</div>
</body>
</html>