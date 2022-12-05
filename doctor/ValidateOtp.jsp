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
<title>Doctor Password</title>
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
}

.btn {
	height: 100%;
	width: 100%;
	background: linear-gradient(135deg, #da83ff, #9f01ea);
}
</style>
<%
response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");

response.setHeader("Cache-Control", "no-store");

response.setHeader("Expires", "0");

response.setDateHeader("Expires", -1);
%>
</head>
<body style="margin-top: 65px; margin-bottom: 100px;">
	<%@include file="navbar.jsp"%>

	<div class="container p-4 ">
		<div class="row">
			<div class="col-4"></div>
			<div class="col-md-4">
				<div class="card paint-card mb-4">
					<p class="text-center fs-3 " style="color: #9F44D3">OTP
						Verification</p>
					

					<div class="card-body">
					<%
					if (request.getAttribute("message") != null) {
						out.print("<p class='text-primary ml-1'>" + request.getAttribute("message") + "</p>");
					}
					%>

						<form action="ValidateOtp" method="post">
							<div class="mb-3">
								<label>Enter Your OTP</label> <input type="text" name="otp"
									class="form-control" required>
							</div>
							<%-- <input type="hidden" value="${doctorObj.id }" name="userId"> --%>
							<input type="submit" class="btn btn-primary" value="Verify">

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>