<!doctype html>
<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>

<html lang="en">
<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="shortcut icon" type="image/png" href="images/gic_logo.png">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="fonts/icomoon/style.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Style -->
<link rel="stylesheet" href="css/style.css">
<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">

<title>Job Linked</title>
<style>
/* Centered text */
.centered {
	position: absolute;
	top: 15%;
	left: 50%;
	transform: translate(-50%, -50%);
}
</style>
</head>
<body>
	<div class="half">
		<div class="bg order-1 order-md-2"
			style="background-image: url('images/bg_1.jpg');"></div>
		<div class="centered">
			<h1>
				<strong>Job Linked Management System</strong>
			</h1>
		</div>
		<div class="contents order-2 order-md-1">
			<div class="container">
				<div class="row align-items-center justify-content-center">
					<div class="col-md-6">
						<div class="form-block">
							<div class="text-center mb-5">
								<h3>
									Login to <strong>Admin Module</strong>
								</h3>
							</div>
							<html:form action="/adminLoginPath">							
								<div class="form-group first">
									<label for="frmLoginEmail">Email</label>
									<html:text property="frmLoginEmail" styleClass="form-control"
										styleId="frmLoginEmail"></html:text>
								</div>
								<div class="form-group last mb-3">
									<label for="frmLoginPassword">Password</label>
									<html:password property="frmLoginPassword"
										styleClass="form-control" styleId="frmLoginPassword">
									</html:password>
								</div>

								<!-- <div class="d-sm-flex mb-5 align-items-center">
				                  <span class="ml-auto"><a href="#" class="forgot-pass">Forgot Password</a></span> 
				                </div> -->

								<html:submit property="btnLogin" value="Login"
									styleClass="btn btn-outline-info btn-block btn-rounded  mb-4">
								</html:submit>

							</html:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ======= Footer ======= -->
	<jsp:include page="/WEB-INF//jsp/inc/footer.jsp"></jsp:include>
	<!-- End Footer -->
	<!-- for error message -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

	<!-- js alert -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

	<!--show error message-->
	<c:if test="${AdminLoginFormBean.loginError!=null}">
		<script type="text/javascript">
			swal("Warning!", "${AdminLoginFormBean.loginError}", "warning");
		</script>
	</c:if>
	<!--show success message-->
	<c:if test="${AdminLoginFormBean.successMsg!=null}">
		<script type="text/javascript">
        swal("Success!", "${AdminLoginFormBean.successMsg}", "success");
      </script>
	</c:if>
	<!-- For Placehoder text -->
	<script>
		$(function() {
			$("#frmLoginPassword").attr("placeholder", "Enter Password");
			$("#frmLoginEmail").attr("placeholder", "Enter Email");
		});
	</script>
</body>

</html>