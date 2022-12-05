<%@page import="com.healthcare.dao.DoctorDAO"%>
<%@page import="com.healthcare.dto.DoctorEntity"%>
<%@page import="com.healthcare.dto.SpecialistEntity"%>
<%@page import="com.healthcare.dao.SpecialistDAO"%>
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
<title>Insert title here</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.navbar {
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
<body>

	<%@include file="navbar.jsp"%>

	<div class="container-fluid p-3 mt-5">
		<div class="row">

			<div class="col-md-5 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center" style="color: #9F44D3">ADD DOCTOR</p>
						<c:if test="${not empty succMsg }">
							<p class="text-center text-success fs-3">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-5">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>

						<form action="../addDoctor" method="post">

							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									required name="fullName" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">DOB</label> <input type="date"
									required name="dob" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label> <input required
									name="qualification" type="text" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Specialist</label> <select
									name="specialistName" required class="form-control">
									<option>--select--</option>

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
									required name="email" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Mobile</label> <input type="text"
									required name="mobile" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									name="password" type="password" class="form-control">
							</div>

							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>