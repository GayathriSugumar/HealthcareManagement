<%@page import="com.healthcare.dao.DoctorDAO"%>
<%@page import="com.healthcare.dto.DoctorEntity"%>
<%@page import="com.healthcare.dto.UserEntity"%>
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
<title>View appointment</title>
<%@include file="component/allcss.jsp"%>
<style type="text/css">
.navbar{
	height: 49px;
	
}
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

.table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
	background-color: #ecdcf5;
}
</style>
</head>
<body>
	<c:if test="${empty userObj }">
		<c:redirect url="user_login.jsp"></c:redirect>
	</c:if>

	<%@include file="component/navbar.jsp"%>

	<div class="container p-4 mt-5">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text-primary">Appointment
							List</p>
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th scope="col">Full Name</th>
										<th scope="col">Gender</th>
										<th scope="col">Age</th>
										<th scope="col">Appoint Date</th>
										<th scope="col">Diseases</th>
										<th scope="col">Doctor Name</th>
										<th scope="col">Status</th>

									</tr>
								</thead>
								<tbody>
									<%
									UserEntity userEntity = (UserEntity) session.getAttribute("userObj");
									AppointmentDAO appointmentDao = new AppointmentDAO(ConnectionProvider.getconnection());
									DoctorDAO doctorDao = new DoctorDAO(ConnectionProvider.getconnection());
									List<AppointmentEntity> list = appointmentDao.getAllAppointmentsByUserId(userEntity.getId());
									for (AppointmentEntity appointment : list) {
										DoctorEntity doctor = doctorDao.getDoctorById(appointment.getDoctorId());
									%>
									<tr>
										<th><%=appointment.getFullName()%></th>
										<td><%=appointment.getGender()%></td>
										<td><%=appointment.getAge()%></td>
										<td><%=appointment.getAppointmentDate()%></td>
										<td><%=appointment.getIllness()%></td>
										<td><%=doctor.getFullName()%></td>
										<td>
											<%
											if ("Pending".equals(appointment.getStatus())) {
											%> <a href="#" class="btn btn-sm btn-warning">Pending</a> <%
 } else {
 %> <%=appointment.getStatus()%> <%
 }
 %>
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
	</div>
</body>
</html>