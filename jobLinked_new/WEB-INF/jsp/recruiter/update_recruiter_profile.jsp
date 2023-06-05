<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Update Profile</title>
<link rel="shortcut icon" type="image/png" href="images/gic_logo.png">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />

<!-- MAIN BOOTSTRAP JSP -->
<jsp:include page="/WEB-INF//jsp/inc/bootstrap_link.jsp"></jsp:include>

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
<style>
body {
	color: #1a202c;
	text-align: left;
}
</style>
<body>
	<!-- ======= Header ======= -->
	<jsp:include page="/WEB-INF//jsp/inc/recruiter_module_header_bstr.jsp"></jsp:include>
	<!-- End Header -->
	<br>
	<br>
	<!-- /Breadcrumb -->
	<div class="container mt-5">
		<div class="main-body">
			<html:form action="/updateRecruiterProfile" method="post"
				enctype="multipart/form-data" styleId="myForm">
				<div class="row">
					<div class="col-lg-4">
						<div class="card">
							<div class="card-body">
								<div class="d-flex flex-column align-items-center text-center">
									<div class="mt-3">
										<img
											src="https://s3.eu-central-1.amazonaws.com/bootstrapbaymisc/blog/24_days_bootstrap/fox.jpg"
											width="150" class="rounded-circle">
										<h4>${sessionScope.RecProfileFormBean.loginUser.firstName}</h4>
										<p class="text-secondary mb-1">${sessionScope.RecProfileFormBean.loginUser.partyGroupPosition.positionName}</p>
										<p class="text-muted font-size-sm">${sessionScope.RecProfileFormBean.loginUser.address}</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-8">
						<div class="card">
							<div class="card-body">
								<div class="row mb-3">
									<div class="col-sm-3">
										<h6 class="mb-0">First Name</h6>
									</div>
									<div class="col-sm-9 text-secondary">
										<html:text property="frmFirstName" styleClass="form-control"
											disabled="false"></html:text>
									</div>
								</div>
								<div class="row mb-3">
									<div class="col-sm-3">
										<h6 class="mb-0">Last Name</h6>
									</div>
									<div class="col-sm-9 text-secondary">
										<html:text property="frmLastName" styleClass="form-control"
											disabled="false"></html:text>
									</div>
								</div>
								<div class="row mb-3">
									<div class="col-sm-3">
										<h6 class="mb-0">Position Name</h6>
									</div>
									<div class="col-sm-9 text-secondary">
										<html:select property="frmPositionName" styleClass="form-select">
											<c:forEach items="${RecProfileFormBean.frmPositionList}"
												var="position">
												<option value="${position.id}" ${position.id==RecProfileFormBean.loginUser.partyGroupPosition.id ? "selected" : ""}>${position.positionName}</option>
											</c:forEach>
										</html:select>
									</div>
								</div>
								<div class="row mb-3">
									<div class="col-sm-3">
										<h6 class="mb-0">Email</h6>
									</div>
									<div class="col-sm-9 text-secondary">
										<html:text property="frmEmail" styleClass="form-control"
											disabled="true"></html:text>
									</div>
								</div>

								<div class="row mb-3">
									<div class="col-sm-3">
										<h6 class="mb-0">Phone</h6>
									</div>
									<div class="col-sm-9 text-secondary">
										<html:text property="frmPhone" styleClass="form-control"
											disabled="false"></html:text>
									</div>
								</div>
								<div class="row mb-3">
									<div class="col-sm-3">
										<h6 class="mb-0">Birth Date</h6>
									</div>
									<div class="col-sm-9 text-secondary">
										<html:text property="frmBirthDate" styleId="calendar"
											maxlength="10" size="15" />
										<html:image src="images/calendar.gif" styleId="trigger"
											style="cursor: pointer; border: 1px solid red;"
											title="Date selector"
											onmouseover="this.style.background='red';"
											onmouseout="this.style.background=''"></html:image>
										<font face="Verdana" size="2" color="blue">&nbsp;YYYY-MM-DD</font>
										<script type="text/javascript">
											//         
											Calendar.setup({
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
								</div>
								<div class="row mb-3">
									<div class="col-sm-3">
										<h6 class="mb-0">Nrc</h6>
									</div>
									<div class="col-sm-9 text-secondary">
										<html:text property="frmNrc" styleClass="form-control"
											disabled="true"></html:text>
									</div>
								</div>
								<div class="row mb-3">
									<div class="col-sm-3">
										<h6 class="mb-0">Gender</h6>
									</div>
									<div class="col-sm-9 text-secondary">
										<html:radio property="frmGender" value="Male">Male</html:radio>
										<html:radio property="frmGender" value="Female">Female</html:radio>
									</div>
								</div>
								<div class="row mb-3">
									<div class="col-sm-3">
										<h6 class="mb-0">Address</h6>
									</div>
									<div class="col-sm-9 text-secondary">
										<html:textarea property="frmAddress" styleClass="form-control"
											disabled="false">
										</html:textarea>
									</div>
								</div>
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
						</div>
					</div>
				</div>
			</html:form>
		</div>
	</div>
	<!-- ======= Footer ======= -->
	<jsp:include page="/WEB-INF//jsp/inc/footer.jsp"></jsp:include>
	<!-- End Footer -->

	<jsp:include page="/WEB-INF//jsp/inc/bootstrap_script.jsp"></jsp:include>

	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>	
	
	<script>
	var position = document.querySelector("#positionName");
	alert(position);
	if (position == RecProfileFormBean.loginUser.partyGroupPosition.positionName) 
		position.selected = true;
	</script> -->
</body>
</html>