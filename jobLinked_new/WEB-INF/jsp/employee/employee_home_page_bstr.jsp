<!doctype html>
<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<html lang="en">
<head>
<title>JobLinked</title>
<link rel="shortcut icon" type="image/png" href="images/gic_logo.png">
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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">
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
	<!-- ======= Header ======= -->
	<jsp:include page="/WEB-INF//jsp/employee/employee_home_menu_bstr.jsp"></jsp:include>
	<!-- End Header -->
	<div class="half">
		<div class="bg order-1 order-md-2"
			style="background-image: url('images/bg_1.jpg');"></div>
		<!-- <div class="centered">
			<h1>
				<strong>Job Linked Management System</strong>
			</h1>
		</div> 
		-->
		<div class="contents order-2 order-md-1">
			<div class="container">
				<div class="row align-items-center justify-content-center">
					<div class="col-md-6">
						<div class="form-block">
							<div class="text-center mb-5">
								<h3>
									Login to <strong>Job Seeker Module</strong>
								</h3>
							</div>
							<html:form action="/empLoginPath">
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

								<html:submit property="btnLogin" value="Login"
									styleClass="btn btn-outline-info btn-block btn-rounded  mb-4">
								</html:submit>
								<div class="d-sm-flex mb-5">
									<span class="ml-auto"> 
									<a href="empForgetPassPath.do" class="forgot-pass"
										style="color: #337ab7; font-style: oblique; font-weight: normal;">Forget
											Password?</a> 
											</span> 																	
								</div>
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

	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>

	<!-- for error message -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

	<!-- js alert -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<!--show error message-->
	<c:if test="${EmpLoginFormBean.loginerror!=null}">
		<script type="text/javascript">
			swal("Warning!", "${EmpLoginFormBean.loginerror}", "warning");
		</script>
	</c:if>
	<!--show success message-->
	<c:if test="${EmpRegFormBean.successMsg!=null}">
		<script type="text/javascript">
        swal("Success!", "${EmpRegFormBean.successMsg}", "success");
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