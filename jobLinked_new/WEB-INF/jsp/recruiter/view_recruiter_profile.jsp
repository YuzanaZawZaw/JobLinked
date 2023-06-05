<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>View Recruiter Profile</title>
<link rel="shortcut icon" type="image/png" href="images/gic_logo.png">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />

<!-- MAIN BOOTSTRAP JSP -->
<jsp:include page="/WEB-INF//jsp/inc/bootstrap_link.jsp"></jsp:include>
<style>
body {
	color: #1a202c;
	text-align: left;
}
</style>
</head>
<body>
	<!-- ======= Header ======= -->
	<jsp:include page="/WEB-INF//jsp/inc/recruiter_module_header_bstr.jsp"></jsp:include>
	<!-- End Header -->
	<!-- ======= Job Post Profile Details Section ======= -->
	<section id="portfolio-details" class="portfolio-details">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<div class="portfolio-info">
					<div class="d-flex flex-column align-items-center text-center">
						<div class="profile-img">
							<img src="https://s3.eu-central-1.amazonaws.com/bootstrapbaymisc/blog/24_days_bootstrap/fox.jpg"
								width="150" class="rounded-circle">
							<h4>${RecProfileFormBean.loginUser.firstName}</h4>
									<p class="text-secondary mb-1">${RecProfileFormBean.loginUser.partyGroupPosition.positionName}</p>
									<p class="text-muted font-size-sm">${RecProfileFormBean.loginUser.address}</p>								
						</div>
					</div>
					</div>
				</div>
				<div class="col-lg-8">
					<div class="portfolio-info">
						<h3 align="center"><font color="#836ea7">Personal Information</font></h3>
						<ul>													
							<li><div class="d-flex justify-content-between">
									<strong>Full Name:</strong>
									${sessionScope.RecProfileFormBean.loginUser.firstName}
									${sessionScope.RecProfileFormBean.loginUser.lastName}
								</div>
							</li>							
							<li><div class="d-flex justify-content-between">
									<strong>Position:</strong>
									<c:set var="position" scope="session"
									value="${sessionScope.RecProfileFormBean.loginUser.partyGroupPosition.positionName}">
								</c:set>
								<c:if test="${empty position}">
    									<font color="red">Please fill out position!</font>
								</c:if>
								<c:if test="${not empty position}">
								   ${sessionScope.RecProfileFormBean.loginUser.partyGroupPosition.positionName}
								</c:if>
								</div>
							</li>
							
							<li><div class="d-flex justify-content-between">
									<strong>Email:</strong>${sessionScope.RecProfileFormBean.loginUser.email}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>Phone:</strong>
									${sessionScope.RecProfileFormBean.loginUser.phoneNo}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>Birth Date:</strong>${sessionScope.RecProfileFormBean.loginUser.birthDate}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>Nrc:</strong>${sessionScope.RecProfileFormBean.loginUser.nrc}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>Gender:</strong>${sessionScope.RecProfileFormBean.loginUser.gender}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>Address:</strong>${sessionScope.RecProfileFormBean.loginUser.address}
								</div>
							</li>						
						</ul>
						<div class="col-sm-12">
							<a class="btn btn-outline-info " href="updateRecruiterProfile.do">Edit</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
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
	<logic:notEmpty property="successMsg" name="RecProfileFormBean">
		<script type="text/javascript">
				swal("Success!", "${RecProfileFormBean.successMsg}", "success");
		</script>
	</logic:notEmpty>
</body>
</html>