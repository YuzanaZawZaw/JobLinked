<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Job Post</title>
<link rel="shortcut icon" type="image/png" href="images/gic_logo.png">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />

<!-- MAIN BOOTSTRAP JSP -->
<jsp:include page="/WEB-INF//jsp/inc/bootstrap_link.jsp"></jsp:include>

<!-- for table style -->
<link rel="stylesheet" href="css/tables.css" />

<!-- calendar stylesheet -->
<link rel="stylesheet" type="text/css" media="all"
	href="js/skins/aqua/theme.css" title="Aqua" />
<!-- main calendar program -->
<script type="text/javascript" src="js/calendar.js"></script>
<!-- language for the calendar -->
<script type="text/javascript" src="js/calendar-en.js"></script>
<!-- the following script defines the Calendar.setup helper function, which makes
       adding a calendar a matter of 1 or 2 lines of code. -->
<script type="text/javascript" src="js/calendar-setup.js"></script>

</head>
<body>
	<!-- ======= Header ======= -->
	<jsp:include page="/WEB-INF//jsp/inc/recruiter_module_header_bstr.jsp"></jsp:include>
	<!-- End Header -->
	<br>
	<br>
	<div class="container mt-5">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<h2>
							<font color="#836ea7">Update a job post</font>
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
										<html:form action="/updateJobPost">
											<div class="form-group first">
												<label class="form-label" for="positionName">Position
													Name:</label>
												<html:text property="frmPositionName" disabled="true"
													styleClass="form-control">
												</html:text>
											</div>

											<div class="form-group first">
												<label class="form-label" for="status">Status:</label>
												<%-- <html:select property="frmStatusName"
													styleClass="form-select">
													<html:option value="0">SELECT</html:option>
													<html:optionsCollection property="frmStatusList" value="id"
														label="description" />
												</html:select> --%>
												<html:select property="frmStatusName"
													styleClass="form-select">
													<c:forEach items="${RecJobPostBean.frmStatusList}"
														var="status">
														<option value="${status.id}"
															${status.description==RecJobPostBean.frmStatusName? "selected" : ""}>${status.description}</option>
													</c:forEach>
												</html:select>
											</div>

											<div class="form-group first">
												<label class="form-label" for="location">Location:</label>
												<html:text property="frmLocation" styleClass="form-control"></html:text>
											</div>

											<div class="form-group first">
												<label class="form-label" for="employmentType">Employment
													Type:</label>
												<html:select property="frmEmploymentType"
													styleClass="form-select">
													<html:option value="0">SELECT</html:option>
													<html:option value="1">Full Time</html:option>
													<html:option value="2">Part Time</html:option>
													<html:option value="3">Intern Ship</html:option>
												</html:select>
											</div>

											<div class="form-group first">
												<label class="form-label" for="location">Salary:</label>
												<html:text property="frmSalary" styleClass="form-control"></html:text>
											</div>

											<div class="form-group first">
												<label class="form-label" for="location">Start Date:</label>
												<html:text property="frmFromDate" styleId="calendar"
													maxlength="10" size="15" />
												<html:image src="images/calendar.gif" styleId="trigger"
													style="cursor: pointer; border: 1px solid red;"
													title="Date selector"
													onmouseover="this.style.background='red';"
													onmouseout="this.style.background=''"></html:image>
												<font face="Verdana" size="2" color="blue">&nbsp;YYYY-MM-DD</font>
												<script type="text/javascript">
													//         
													Calendar
															.setup({
																firstDay : 1,
																electric : false,
																singleClick : true,
																inputField : "calendar",
																button : "trigger",
																ifFormat : "%Y-%m-%d",
																daFormat : "%Y-%m-%d"
															});
													//
												</script>
											</div>
											<div class="form-group first">
												<label class="form-label" for="location">End Date:</label>
												<html:text property="frmThruDate" styleId="calendar1"
													maxlength="10" size="15" />
												<html:image src="images/calendar.gif" styleId="trigger1"
													style="cursor: pointer; border: 1px solid red;"
													title="Date selector"
													onmouseover="this.style.background='red';"
													onmouseout="this.style.background=''"></html:image>
												<font face="Verdana" size="2" color="blue">&nbsp;YYYY-MM-DD</font>
												<script type="text/javascript">
													//         
													Calendar
															.setup({
																firstDay : 1,
																electric : false,
																singleClick : true,
																inputField : "calendar1",
																button : "trigger1",
																ifFormat : "%Y-%m-%d",
																daFormat : "%Y-%m-%d"
															});
													//
												</script>
											</div>
											<div class="d-flex flex-column mt-3">
												<div class="row">
													<div class="col-sm-3"></div>
													<div class="col-sm-9 text-secondary">
														<html:submit property="btnUpdate"
															styleClass="btn btn-outline-info" value="Save Changes">
														</html:submit>
														<html:submit property="btnUpdateCancel"
															styleClass="btn btn-outline-warning" value="Cancel">
														</html:submit>
													</div>
												</div>
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
	<!-- for modal -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

	<jsp:include page="/WEB-INF//jsp/inc/bootstrap_script.jsp"></jsp:include>

	<!-- for error message -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<!-- js alert -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

	<c:if test="${RecJobPostBean.errorMsg!=null}">
		<script type="text/javascript">
			swal("Warning!", "${RecJobPostBean.errorMsg}", "warning");
		</script>
	</c:if>
</body>
</html>