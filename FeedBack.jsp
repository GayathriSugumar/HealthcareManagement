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
<title>Insert title here</title>
<%@include file="component/allcss.jsp"%>
<link href="feedback.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
.navbar {
	height: 49px;
}

body {
	background: url(image/review2.jpg) no-repeat center center fixed;
	/*  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover; 
  style="background: linear-gradient(#ffff, #dda3ff)"*/
	background-size: cover;
	background-width: 80%;
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
	opacity: 1
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<div class="container-fulid  p-5">
		<div class="row">

			<div class="col-md-2"></div>

			<div class="col-md-8 p-5">
				<div class="wrapper p-3">
					<div class="master">
						<h2 style="color: #ff5a49">Review And rating</h2>
						<h1>How was your experience about our Services?</h1>
						
						<form action="Feedback" method="post">

						<div class="rating-component">
							<div class="status-msg">
								<label> <input class="rating_msg" type="hidden"
									name="rating_msg" value="" />
								</label>
							</div>
							<div class="stars-box">
								<i class="star fa fa-star" title="1 star" data-message="Poor"
									data-value="1"></i> <i class="star fa fa-star" title="2 stars"
									data-message="Too bad" data-value="2"></i> <i
									class="star fa fa-star" title="3 stars"
									data-message="Average quality" data-value="3"></i> <i
									class="star fa fa-star" title="4 stars" data-message="Nice"
									data-value="4"></i> <i class="star fa fa-star" title="5 stars"
									data-message="very good qality" data-value="5"></i>
							</div>
							<div class="starrate">
								<label> <input class="ratevalue" type="hidden"
									name="rate_value" value="" />
								</label>
							</div>
						</div>

						<div class="feedback-tags">
							<div class="tags-container" data-tag-set="1">
								<div class="question-tag">Why was your experience so bad?</div>
							</div>
							<div class="tags-container" data-tag-set="2">
								<div class="question-tag">Why was your experience so bad?</div>

							</div>

							<div class="tags-container" data-tag-set="3">
								<div class="question-tag">Why was your average rating
									experience ?</div>
							</div>
							<div class="tags-container" data-tag-set="4">
								<div class="question-tag">Why was your experience good?</div>
							</div>

							<div class="tags-container" data-tag-set="5">
								<div class="make-compliment">
									<div class="compliment-container">
										Give a compliment <i class="far fa-smile-wink"></i>
									</div>
								</div>
							</div>
							
							<div class="tags-box">
								<input type="text" class="tag form-control" name="Name"
									id="inlineFormInputName" placeholder="please enter your Name">
									</div>

							<div class="tags-box">
								<input type="text" class="tag form-control" name="comment"
									id="inlineFormInputName" placeholder="please enter your review">
								<!-- <input type="hidden" name="product_id"
									value="{{ $products->id }}" /> -->
							</div>

						</div>

						<div class="button-box" align="center">
							<input type="submit" class=" done btn btn-warning"
								disabled="disabled" value="Add review" />
						</div>

						<div class="submited-box">
							<div class="loader"></div>
							<div class="success-message">Thank you!</div>
						</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		$(".rating-component .star").on("mouseover", function() {
			var onStar = parseInt($(this).data("value"), 10); //
			$(this).parent().children("i.star").each(function(e) {
				if (e < onStar) {
					$(this).addClass("hover");
				} else {
					$(this).removeClass("hover");
				}
			});
		}).on("mouseout", function() {
			$(this).parent().children("i.star").each(function(e) {
				$(this).removeClass("hover");
			});
		});

		$(".rating-component .stars-box .star").on("click", function() {
			var onStar = parseInt($(this).data("value"), 10);
			var stars = $(this).parent().children("i.star");
			var ratingMessage = $(this).data("message");

			var msg = "";
			if (onStar > 1) {
				msg = onStar;
			} else {
				msg = onStar;
			}
			$('.rating-component .starrate .ratevalue').val(msg);

			$(".fa-smile-wink").show();

			$(".button-box .done").show();

			if (onStar === 5) {
				$(".button-box .done").removeAttr("disabled");
			} else {
				$(".button-box .done").attr("disabled", "true");
			}

			for (i = 0; i < stars.length; i++) {
				$(stars[i]).removeClass("selected");
			}

			for (i = 0; i < onStar; i++) {
				$(stars[i]).addClass("selected");
			}

			$(".status-msg .rating_msg").val(ratingMessage);
			$(".status-msg").html(ratingMessage);
			$("[data-tag-set]").hide();
			$("[data-tag-set=" + onStar + "]").show();
		});

		$(".feedback-tags  ").on(
				"click",
				function() {
					var choosedTagsLength = $(this).parent("div.tags-box")
							.find("input").length;
					choosedTagsLength = choosedTagsLength + 1;

					if ($(this).hasClass("choosed")) {
						$(this).removeClass("choosed");
						choosedTagsLength = choosedTagsLength - 2;
					} else {
						$(this).addClass("choosed");
						$(".button-box .done").removeAttr("disabled");
					}

					console.log(choosedTagsLength);

					if (choosedTagsLength <= 0) {
						$(".button-box .done").attr("enabled", "false");
					}
				});

		$(".compliment-container .fa-smile-wink").on("click", function() {
			$(this).fadeOut("slow", function() {
				$(".list-of-compliment").fadeIn();
			});
		});

		$(".done").on("click", function() {
			$(".rating-component").hide();
			$(".feedback-tags").hide();
			$(".button-box").hide();
			$(".submited-box").show();
			$(".submited-box .loader").show();

			setTimeout(function() {
				$(".submited-box .loader").hide();
				$(".submited-box .success-message").show();
			}, 1500);
		});
	</script>
</body>
</html>