<%@page import="com.healthcare.dao.DoctorDAO"%>
<%@page import="com.healthcare.dto.DoctorEntity"%>
<%@page import="com.healthcare.dto.SpecialistEntity"%>
<%@page import="com.healthcare.dao.SpecialistDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.healthcare.util.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name = "viewport" content = "width = device-width, initial-scale = 1.0">
<title>Insert title here</title>
<%@include file="../component/allcss.jsp"%>
<!--  <link href="../indexnav.css" rel="stylesheet"> -->
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
</head>
<body>

	<%@include file="navbar.jsp"%>

	<div class="container-fluid p-3 mt-5">
		<div class="row">

			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-5 text-center text-primary">Doctors Details</p>
						<div class="table-responsive">
							<table class="table table-hover">
								<thead>
									<tr>
										<th scope="col">FullName</th>
										<th scope="col">DOB</th>
										<th scope="col">Qualification</th>
										<th scope="col">Specilaist</th>
										<th scope="col">Email</th>
										<th scope="col">Mobile</th>
										<th scope="col">Action</th>
									</tr>
								</thead>

								<tbody>
									<%
									DoctorDAO doctorDao = new DoctorDAO(ConnectionProvider.getconnection());
									List<DoctorEntity> list1 = doctorDao.getAllDoctorEntity();
									for (DoctorEntity doctor : list1) {
									%>

									<tr>
										<td><%=doctor.getFullName()%></td>
										<td><%=doctor.getDob()%></td>
										<td><%=doctor.getQualification()%></td>
										<td><%=doctor.getSpecialistName()%></td>
										<td><%=doctor.getEmail()%></td>
										<td><%=doctor.getMobile()%></td>
										<td><a href="edit_doctor.jsp?id=<%=doctor.getId()%>"
											class="btn btn-sm btn-primary">Edit</a> <a
											href="../deleteDoctor?id=<%=doctor.getId()%>"
											class="btn btn-sm btn-danger">Delete</a></td>
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