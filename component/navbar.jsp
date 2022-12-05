<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<header>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top pt-1 pb-1"
		style="background: #9F44D3">

		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp"><img
				src="image/pngwing.png" height="48px">Lilac Medic Cure</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">

					<c:if test="${empty userObj }">

						<li class="nav-item px-3"><a class="nav-link active"
							aria-current="page" href="index.jsp">Home</a></li>

						<li class="nav-item px-3"><a class="nav-link active"
							aria-current="page" href="admin_login.jsp">Admin</a></li>

						<li class="nav-item px-3"><a class="nav-link active"
							aria-current="page" href="doctor_login.jsp">Doctor</a></li>

						<li class="nav-item px-3"><a class="nav-link active"
							aria-current="page" href="user_login.jsp">User</a></li>

						<li class="nav-item px-3"><a class="nav-link active"
							aria-current="page" href="user_appointment.jsp">Appointment</a></li>
							
						<li class="nav-item px-3"><a class="nav-link active"
							aria-current="page" href="FeedBack.jsp">Feed Back</a></li>

					</c:if>

					<c:if test="${not empty userObj }">
						<li class="nav-item px-3"><a class="nav-link active"
							aria-current="page" href="user_appointment.jsp">Appointment</a></li>

						<li class="nav-item px-3"><a class="nav-link active"
							aria-current="page" href="view_appointment.jsp">View
								Appointment</a></li>


						<div class="dropdown px-4">
							<button class="btn btn-secondary dropdown-toggle" type="button"
								id="dropdownMenuButton1" data-bs-toggle="dropdown"
								aria-expanded="false">
								<i class="fas fa-user-circle"></i>${userObj.fullName }
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
								<li><a class="dropdown-item" href="changePassword.jsp">Change Password</a></li>
								<li><a class="dropdown-item"  href="userLogout">Logout</a></li>

							</ul>
						</div>


					</c:if>
				</ul>
			</div>
		</div>

	</nav>
</header>

<!-- linear-gradient( #ffff, #9F44D3); -->
