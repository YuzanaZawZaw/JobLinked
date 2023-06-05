<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Forget Password</title>
<link rel="shortcut icon" type="image/png" href="images/gic_logo.png">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<!-- MAIN BOOTSTRAP JSP -->
<jsp:include page="/WEB-INF//jsp/inc/bootstrap_link.jsp"></jsp:include>
</head>
<body>
	<!-- ======= Header ======= -->
	<jsp:include
		page="/WEB-INF//jsp/recruiter/recruiter_home_menu_bstr.jsp"></jsp:include>
	<!-- End Header -->
	<br />
	<br />
	<div class="container mt-5">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<h2 align="center">
							<font color="#836ea7">Forget Password</font>
						</h2>
					</div>
				</div>
				<div class="row gutters-sm mt-3">
					<div class="col-md-3 mb-3"></div>
					<div class="col-md-6 mb-3">
						<div class="card">
							<div class="card-body">
								<div class="d-flex flex-column">
									<div class="mt-3">
										<html:form action="/recForgetPassPath">
											<div class="mt-3">
												<font color="red"> <html:errors
														property="frmForgetPassEmail" /> <html:errors
														property="frmForgetPassSecurityQuest" /> </font>
											</div>

											<div class="mt-3">
												<html:text property="frmForgetPassEmail"
													styleClass="form-control" styleId="frmForgetPassEmail"></html:text>
											</div>

											<div class="mt-3">
												<html:text property="frmForgetPassSecurityQuest"
													styleClass="form-control"
													styleId="frmForgetPassSecurityQuest"></html:text>
											</div>
											<div class="text-center mt-3">
												<html:submit property="btnLogin" value="Login"
													styleClass="btn btn-outline-info btn-block btn-rounded  mb-4">
												</html:submit>
											</div>
										</html:form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ======= Footer ======= -->
	<jsp:include page="/WEB-INF//jsp/inc/footer.jsp"></jsp:include>
	<!-- End Footer -->
	
	<jsp:include page="/WEB-INF//jsp/inc/bootstrap_script.jsp"></jsp:include>

	<!-- for error message -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

	<!-- js alert -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	
	<!--show error message-->
	<c:if test="${RecFormBean.forgetPassError!=null}">
		<script type="text/javascript">
			swal("Warning!", "${RecFormBean.forgetPassError}", "warning");
		</script>
	</c:if>

	<!-- For Placehoder text -->
	<script>
		$(function() {
			$("#frmForgetPassEmail").attr("placeholder", "Enter your email");
			$("#frmForgetPassSecurityQuest").attr("placeholder",
					"Enter...What is your dream city?");
		});
	</script>
</body>
</html>
