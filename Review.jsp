<%@page import="com.healthcare.dto.FeedbackEntity"%>
<%@page import="com.healthcare.dao.FeedbackDAO"%>
<%@page import="com.healthcare.util.ConnectionProvider"%>
<%@page import="java.util.List"%>
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
<title>Comments</title>
<%@include file="component/allcss.jsp"%>
<link href="feedback.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
.navbar {
	height: 49px;
}

body {
	background: linear-gradient(#ffff, #9F44D3);
	font-family: 'Calibri', sans-serif !important
}

.mt-100 {
	margin-top: 100px
}

.mb-100 {
	margin-bottom: 100px
}

.card {
	position: relative;
	display: -webkit-box;
	display: -ms-flexbox;
	display: flex;
	-webkit-box-orient: vertical;
	-webkit-box-direction: normal;
	-ms-flex-direction: column;
	flex-direction: column;
	min-width: 0;
	word-wrap: break-word;
	background-color: #fff;
	background-clip: border-box;
	border: 0px solid transparent;
	border-radius: 0px
}

.card-body {
	-webkit-box-flex: 1;
	-ms-flex: 1 1 auto;
	flex: 1 1 auto;
	padding: 1.25rem
}

.card .card-title {
	position: relative;
	font-weight: 600;
	margin-bottom: 10px
}

.comment-widgets {
	position: relative;
	margin-bottom: 10px
}

.comment-widgets .comment-row {
	border-bottom: 1px solid transparent;
	padding: 14px;
	display: -webkit-box;
	display: -ms-flexbox;
	display: flex;
	margin: 10px 0
}

.p-2 {
	padding: 0.5rem !important
}

.comment-text {
	padding-left: 15px
}

.w-100 {
	width: 100% !important
}

.m-b-15 {
	margin-bottom: 15px
}

.btn-sm {
	padding: 0.25rem 0.5rem;
	font-size: 0.76563rem;
	line-height: 1.5;
	border-radius: 1px
}

.btn-cyan {
	color: #fff;
	background-color: #27a9e3;
	border-color: #27a9e3
}

.btn-cyan:hover {
	color: #fff;
	background-color: #1a93ca;
	border-color: #198bbe
}

.comment-widgets .comment-row:hover {
	background: rgba(0, 0, 0, 0.05)
}

.wrapper {
	border-radius: 5px;
	box-shadow: 10px 10px 16px -2px rgba(55, 8, 242, 0.75);
	background: linear-gradient(90deg, rgba(255, 255, 255, 1) 12%,
		rgba(237, 236, 237, 1) 100%);
	opacity: 0.6;
	transition: 0.3s;

	/* background: linear-gradient(#ffff, #edeced); */
}

.wrapper:hover {
	opacity: 1;
}
.table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
	background-color: #ecdcf5;
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<div class="row d-flex justify-content-center mt-100 mb-100">
		<div class="col-lg-6">
			<div class="card">
				<div class="card-body text-center">
					<h4 class="card-title" style="color: #9F44D3">Comments</h4>
				</div>
				<div class="container p-4">
					<div class="row">
						<div class="col-md-12">
							<div class="card paint-card">
								<div class="card-body">
									<div class="table-responsive">
										<table class="table">


											<%
											FeedbackDAO feedbackDao = new FeedbackDAO(ConnectionProvider.getconnection());

											List<FeedbackEntity> list = feedbackDao.getAllFeedbacks();
											for (FeedbackEntity feedback : list) {
											%>

											<tr>
												<th><%=feedback.getName()%></th>
												<td><%=feedback.getReview()%></td>
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

									<!-- Card -->
								</div>
							</div>
						</div>
			
</body>
</html>

<!-- Comment Row 

<div class="comment-text w-100">
							<h6 class="font-medium"></h6>
							<span class="m-b-15 d-block"></span>
-->
<!-- <div class="d-flex flex-row comment-row">
						<div class="p-2">
							<img src="https://i.imgur.com/8RKXAIV.jpg" alt="user" width="50"
								class="rounded-circle">
						</div>
						<div class="comment-text active w-100">
							<h6 class="font-medium">Michael Hussey</h6>
							<span class="m-b-15 d-block">Thanks bbbootstrap.com for
								providing such useful snippets. </span>
							<div class="comment-footer">	
							</div>
						</div>
					</div>
					Comment Row
					<div class="d-flex flex-row comment-row">
						<div class="p-2">
							<img src="https://i.imgur.com/J6l19aF.jpg" alt="user" width="50"
								class="rounded-circle">
						</div>
						<div class="comment-text w-100">
							<h6 class="font-medium">Johnathan Doeting</h6>
							<span class="m-b-15 d-block">Great industry leaders are
								not the real heroes of stock market. </span>
							<div class="comment-footer">
								<span class="text-muted float-right">August 1, 2019</span>
								<button type="button" class="btn btn-cyan btn-sm">Edit</button>
								<button type="button" class="btn btn-success btn-sm">Publish</button>
								<button type="button" class="btn btn-danger btn-sm">Delete</button>
							</div>
						</div>
					</div>
				</div> -->