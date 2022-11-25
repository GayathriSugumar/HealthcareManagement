<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

	<nav class="navbar navbar-expand-md navbar-dark fixed-top "
		style="background: #9F44D3">
		
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp"><img
				src="../image/pngwing.png" height="48px">Lilac Medic Cure</a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">

					<li class="nav-item px-4"><a class="nav-link active"
						aria-current="page" href="index.jsp">Home</a></li>

					<li class="nav-item px-4"><a class="nav-link active"
						aria-current="page" href="patient.jsp">Patient</a></li>

				</ul>
				
				<div class="dropdown px-4">
					<button class="btn btn-secondary dropdown-toggle" type="button"
						id="dropdownMenuButton1" data-bs-toggle="dropdown"
						aria-expanded="false">
						<i class="fas fa-user-circle"></i> ${doctorObj.fullName }</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							<li><a class="dropdown-item " href="edit_Profile.jsp">Edit Profile</a></li>
							<li><a class="dropdown-item " href="../doctorLogout">Logout</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>


