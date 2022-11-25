<%@page import="com.healthcare.util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name = "viewport" content = "width = device-width, initial-scale = 1.0">
<title>index</title>
<%@include file="component/allcss.jsp"%>
<style type="text/css">
.navbar {
	height: 49px;
}
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

</style>

</head>
<body style="margin-top: 50px;">
	<%@include file="component/navbar.jsp"%>


	<div id="carouselExampleIndicators" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="3" aria-label="Slide 4"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="4" aria-label="Slide 5"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="5" aria-label="Slide 6"></button>
		</div>


		<div class="carousel-inner ">
			<div class="carousel-item active">
				<img src="image/doctors.jpg" class="d-block w-100" alt="..."
					height="400px">
			</div>
			<div class="carousel-item">
				<img src="image/piles.jpg" class="d-block w-100" alt="..."
					height="400px">
			</div>
			<div class="carousel-item">
				<img src="image/ads.jpg" class="d-block w-100" alt="..."
					height="400px">
			</div>
			<div class="carousel-item">
				<img src="image/kid3.jpg" class="d-block w-100" alt="..."
					height="400px">
			</div>
			<div class="carousel-item">
				<img src="image/kid1.png" class="d-block w-100" alt="..."
					height="400px">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>


	<div class="container p-3">
		<p class="text-center fs-2 ">Key Features of our Hospital</p>

		<div class="row">
		
			<div class="col-md-8 p-5">
				<div class="row">
					<div class="col-md-6">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">100% Safety</p>
								<p>The safety of a patient should be the at most
									priority.Safety of patients is as important as health. Never
									compromise with the safety of patients. We're take extra care
									of the patient's safety.</p>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Clean Environment</p>
								<p>Our Hospital environmental is clean and hyginic.There is
									availability of appropriate cleaning and disinfection materials
									and equipment are available in campus.</p>
							</div>
						</div>
					</div>
					<div class="col-md-6 mt-2">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Friendly Doctors</p>
								<p>A doctor is one who's gentle as a bird, A doctor is one
									who's caring as a mother. Treating the sick is not a comfort
									job.We are taking care of patients</p>
							</div>
						</div>
					</div>
					<div class="col-md-6 mt-2">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Medical Research</p>
								<p>Recent advances in AI-based software offer unprecedented
									new opportunities to help speed up this stage of drug discovery
									and get effective drugs to patients, faster.</p>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<img alt="" src="image/doctors_index.jpg" height="400px">
			</div>

		</div>
	</div>

	<hr>

	<div class="container p-2">
		<p class="text-center fs-2 ">Our Team</p>

		<div class="row">
			<div class="col-md-4 mb-4">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img src="image/doctor3.jpg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr.Samuani Simi</p>
						<p class="fs-7">(CEO & Chairman)</p>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img src="image/doctor4.jpg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr.Shivani</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img src="image/doctor5.jpg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr. Niuise Paule</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img src="image/doctor6.jpg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr. Lee sungyung</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img src="image/doctor1.jpg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr. Yoon Park</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img src="image/doctor2.jpg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr. Park Shin Hye</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>


		</div>

	</div>


</body>
<%@include file="component/footer.jsp"%>
</html>