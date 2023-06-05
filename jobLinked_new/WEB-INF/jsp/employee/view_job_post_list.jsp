<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>View Job Post List</title>
<link rel="shortcut icon" type="image/png" href="images/gic_logo.png">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />

<!-- MAIN BOOTSTRAP JSP -->
<jsp:include page="/WEB-INF//jsp/inc/bootstrap_link.jsp"></jsp:include>

<!-- for table style -->
<link rel="stylesheet" href="css/tables.css" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css"
	integrity="sha256-3sPp8BkKUE7QyPSl6VfBByBroQbKxKG7tsusY2mhbVY="
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<style>
.getstarted,.getstarted:focus {
	color: #836ea7;
	padding: 8px 25px;
	margin-left: 30px;
	border-radius: 4px;
	border: 2px solid #836ea7;
	transition: 0.3s;
	font-size: 14px;
}

.getstarted:hover,.getstarted:focus:hover {
	background: #836ea7;
	color: #fff;
}

/* ===== Career ===== */
.career-form {
	background-color: #9786b3;
	border-radius: 5px;
	padding: 0 16px;
}

.career-form .form-control {
	background-color: rgba(255, 255, 255, 0.2);
	border: 0;
	padding: 12px 15px;
	color: #fff;
}

.career-form .form-control::-webkit-input-placeholder {
	/* Chrome/Opera/Safari */
	color: #fff;
}

.career-form .form-control::-moz-placeholder { /* Firefox 19+ */
	color: #fff;
}

.career-form .form-control:-ms-input-placeholder { /* IE 10+ */
	color: #fff;
}

.career-form .form-control:-moz-placeholder { /* Firefox 18- */
	color: #fff;
}

.career-form .custom-select {
	background-color: rgba(255, 255, 255, 0.2);
	border: 0;
	padding: 12px 15px;
	color: #fff;
	width: 100%;
	border-radius: 5px;
	text-align: left;
	height: auto;
	background-image: none;
}

.career-form .custom-select:focus {
	-webkit-box-shadow: none;
	box-shadow: none;
}

.career-form .select-container {
	position: relative;
}

.career-form .select-container:before {
	position: absolute;
	right: 15px;
	top: calc(50% -   
		                                                              
		        14px);
	font-size: 18px;
	color: #ffffff;
	content: '\F2F9';
	font-family: "Material-Design-Iconic-Font";
}

ul {
	list-style: none;
}

.list-disk li {
	list-style: none;
	margin-bottom: 12px;
}

.list-disk li:last-child {
	margin-bottom: 0;
}
</style>
</head>
<body>
	<!-- ======= Header ======= -->
	<jsp:include page="/WEB-INF//jsp/inc/employee_module_header_bstr.jsp"></jsp:include>
	<!-- End Header -->
	<br>
	<br>
	<div class="container mt-5 d-flex justify-content-center">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<h2 align="center">
							<font color="#836ea7">View Job Post List</font>
						</h2>
					</div>
				</div>
				<div class="row gutters-sm mt-3">
					<div class="col-md-2 mb-3"></div>
					<div class="col-md-8 mb-3">
						<html:form action="/viewJobPostList"
							styleClass="career-form mb-60">
							<div class="row">
								<div class="d-flex justify-content-between">
									<div class="col-md-4 col-lg-3 my-3">
										<div class="ui-widget">
											<html:text property="frmLocation" styleClass="form-control"
												styleId="frmLocation"></html:text>
										</div>
									</div>
									<div class="col-md-6 col-lg-3 my-3">
										<html:select property="frmPositionName"
											styleClass="form-select">
											<html:option value="0">All</html:option>
											<html:optionsCollection property="frmPositionList" value="id"
												label="positionName" />
										</html:select>
									</div>
									<div class="col-md-2 col-lg-3 my-3">
										<html:submit property="btnSearch" value="Search"
											styleClass="getstarted scrollto">
										</html:submit>
									</div>
								</div>
							</div>
						</html:form>
					</div>
				</div>
				<div class="row gutters-sm mt-3">
					<div class="row">
						<div class="col-md-2 mb-3"></div>
						<div class="col-md-8 mb-3">
							<div class="row">
								<logic:notEmpty property="frmJobPostList"
									name="ViewJobPostListBean">
									<c:forEach
										items="${sessionScope.ViewJobPostListBean.frmJobPostList}"
										var="list">
										<html:hidden property="searchByLocation"
											styleClass="form-control" value="${list.location}"
											styleId="searchByLocation" />
										<html:hidden property="viewId" styleClass="form-control"
											value="${list.id}" styleId="viewId" />
										<div class="col-md-6 mb-3">
											<div class="card" style="width: 100%;">
												<div class="card-body">
													<h4 class="card-title text-center">${list.partyGroupPosition.positionName}</h4>

													<div class="d-flex justify-content-between">
														<i class="zmdi zmdi-pin mr-2"></i>&nbsp;&nbsp;${list.location}
													</div>

													<div class="d-flex justify-content-between">
														<i class="zmdi zmdi-balance mr-2"></i>&nbsp;&nbsp;${list.partyGroupPosition.partyGroup.groupNameLocal}
													</div>

													<div class="d-flex justify-content-between">
														<i class="zmdi zmdi-money mr-2"></i>&nbsp;&nbsp;${list.salary}
													</div>
													<div class="d-flex justify-content-between">
														<c:set var="newEmploymentType" scope="session"
															value="${list.employmentType}">
														</c:set>
														<c:if test="${newEmploymentType==1}">
															<i class="zmdi zmdi-time mr-2"></i>&nbsp;&nbsp;Full
														Time<br>
														</c:if>
														<c:if test="${newEmploymentType==2}">
															<i class="zmdi zmdi-time mr-2"></i>&nbsp;&nbsp;Part
														Time<br>
														</c:if>
														<c:if test="${newEmploymentType==3}">
															<i class="zmdi zmdi-time mr-2"></i>&nbsp;&nbsp;Intern
														Ship<br>
														</c:if>
													</div>
													<div class="d-flex justify-content-between">
														<a class="btn btn-outline-info btn-block btn-rounded"
															href="viewJobPostFromEmp.do?frmJobPostId=${list.id}"><font
															color="#836ea7">View</font> </a> <a
															href="applyJobPost.do?frmJobPostId=${list.id}"
															class="btn btn-outline-success btn-block btn-rounded"><font
															color="#836ea7">Apply</font> </a>														
													</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</logic:notEmpty>
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
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js">
	</script>
	<!-- js alert -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	
	<!-- For Placehoder text -->
	<script>
		$(function() {
			$("#frmLocation").attr("placeholder", "Search by location");
		});
	</script>
	<!-- for auto-completement -->
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script>
		var availableTags = [];
		var frmLocation = document.querySelectorAll("#searchByLocation");
		for ( var i = 0; i < frmLocation.length; i++) {
			availableTags[i] = (frmLocation[i].value);
		}
		$("#frmLocation").autocomplete({
			source : availableTags
		});
	</script>
	   
	<!--show success message-->
	<c:if test="${ViewJobPostListBean.successMsg!=null}">
		<script type="text/javascript">
			swal("Success!", "${ViewJobPostListBean.successMsg}", "success");
		</script>
	</c:if>
	<!--show error message-->
	<c:if test="${ViewJobPostListBean.errorMsg!=null}">
		<script type="text/javascript">
        swal("Warning!", "${ViewJobPostListBean.errorMsg}", "warning");
      </script>
	</c:if>               
</body>
</html>
