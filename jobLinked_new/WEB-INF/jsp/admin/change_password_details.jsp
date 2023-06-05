<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Admin Change Password</title>
<link rel="shortcut icon" type="image/png" href="images/gic_logo.png">
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />

<!-- MAIN BOOTSTRAP JSP -->
<jsp:include page="/WEB-INF//jsp/inc/bootstrap_link.jsp"></jsp:include>


</head>
<body>
	<!-- ======= Header ======= -->
	<jsp:include page="/WEB-INF//jsp/inc/admin_module_header_bstr.jsp"></jsp:include>
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
							<font color="#836ea7">Admin Change Password</font>
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
										<html:form action="/adminChangePasswordPath">
											<%-- <tr>
													<td><font color="red">
														<html:errors
																property="frmChangeOldPassword" /> <html:errors
																property="frmChangeNewPassword" /> <html:errors
																property="frmChangeConfirmPassword" />
														</font>
													</td>
											</tr> --%>
											<div class="form-group first">
												<label class="form-label" for="description">
													Email:</label>
												<strong><%@ include file="/WEB-INF/jsp/inc/admin_login_email.jsp"%></strong>
											</div>

											<div class="form-group first">
												<label class="form-label" for="description">Old
													Password:</label>
												<html:password property="frmChangeOldPassword"
													styleClass="form-control">
												</html:password>
											</div>
											<div class="form-group first">
												<label class="form-label" for="description">Old
													New Password:</label>
												<html:password property="frmChangeNewPassword"
														styleClass="form-control">
												</html:password>
											</div>
											<div class="form-group first">
												<label class="form-label" for="description">Old
													Confirmed Password:</label>
												<html:password property="frmChangeConfirmPassword"
														styleClass="form-control">
												</html:password>
											</div>
											<div class="d-flex flex-column align-items-center mt-3">
												<html:submit property="btnUpdate" value="Update"
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
	<!-- show error message -->
	<c:if test="${AdminLoginFormBean.passwordError!=null}">
		<script type="text/javascript">
        swal("Warning!", "${AdminLoginFormBean.passwordError}", "warning");
      </script>
	</c:if>
</body>
</html>
