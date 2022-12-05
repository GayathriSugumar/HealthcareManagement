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
<title>Edit Doctor profile</title>
<%@include file="../component/allcss.jsp"%>
<link href="../indexnav.css" rel="stylesheet">
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

.form-label {
	font-size: 14px;
}

.table {
	font-size: 14px;
}
</style>
</head>
<%
response.setHeader("Pragma", "no-cache");

response.setHeader("Cache-Control", "no-store");

response.setHeader("Expires", "0");

response.setDateHeader("Expires", -1);
%>
<body>
	<%@include file="navbar.jsp"%>
	
	<div class="container-fluid p-3 mt-5">
		<div class="row">

			<div class="col-md-4 offset-md-4">
				<div class="card paint-card ">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Doctor Details</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						DoctorDAO doctorDao = new DoctorDAO(ConnectionProvider.getconnection());
						DoctorEntity doctor = doctorDao.getDoctorById(id);
						%>


						<form action="../updateDoctor" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									required name="fullName" class="form-control"
									value="<%=doctor.getFullName()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">DOB</label> <input type="date"
									value="<%=doctor.getDob() %>" required name="dob"
									class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label> <input required
									value="<%=doctor.getQualification()%>" name="qualification"
									type="text" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Specialist</label> <select name="specialistName"
									required class="form-control">
									<option><%=doctor.getSpecialistName()%></option>

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
									value="<%=doctor.getEmail()%>" required name="email"
									class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Mob No</label> <input type="text"
									value="<%=doctor.getMobile()%>" required name="mobile"
									class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									value="<%=doctor.getPassword()%>" name="password" type="text"
									class="form-control">
							</div>
							<input type="hidden" name="id" value="<%=doctor.getId()%>">

							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>