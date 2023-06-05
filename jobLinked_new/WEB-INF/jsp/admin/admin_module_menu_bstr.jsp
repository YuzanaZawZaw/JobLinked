<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>JobLinked</title>
<link rel="shortcut icon" type="image/png" href="images/gic_logo.png">

<jsp:include page="/WEB-INF//jsp/inc/bootstrap_link.jsp"></jsp:include>
</head>

<body>

	<!-- ======= Header ======= -->
	<jsp:include page="/WEB-INF//jsp/inc/admin_module_header_bstr.jsp"></jsp:include>
	<!-- End Header -->

	<!-- ======= Hero Section ======= -->
	<section id="hero">
		<div id="heroCarousel" data-bs-interval="5000"
			class="carousel slide carousel-fade" data-bs-ride="carousel">				
				<!-- Slide 1 -->
				<div class="carousel-item active">
					<div class="carousel-container">
						<div class="container">
							<h2 class="animate__animated animate__fadeInDown">
								Welcome to <span>Admin Module</span>
							</h2>
							<p class="animate__animated animate__fadeInUp">
								Hey Admin! Welcome to Our Job Linked Management system <br>Here
								You can manage Master Data<br>Go on the above menu section
								links to perform your operations
							</p>
						</div>
					</div>
				</div>		
		</div>
	</section>
	<!-- End Hero -->


	<!-- ======= Footer ======= -->
		<jsp:include page="/WEB-INF//jsp/inc/footer.jsp"></jsp:include>
	<!-- End Footer -->
	
	<jsp:include page="/WEB-INF//jsp/inc/bootstrap_script.jsp"></jsp:include>
	
	<!-- for error message -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

	<!-- js alert -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<!--show success message-->
	<c:if test="${AdminLoginFormBean.successMsg!=null}">
		<script>
			swal("Success!", "${AdminLoginFormBean.successMsg}", "success");
		</script>
	</c:if>
</body>

</html>