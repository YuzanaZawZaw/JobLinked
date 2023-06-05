<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Profile</title>
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
	<jsp:include page="/WEB-INF//jsp/inc/employee_module_header_bstr.jsp"></jsp:include>
	<!-- End Header -->
	<br>
	<br>
	<!-- ======= Job Post Profile Details Section ======= -->
	<section id="portfolio-details" class="portfolio-details">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<div class="portfolio-info">
					<div class="d-flex flex-column align-items-center text-center">
						<div class="profile-img">
							<html:img src="${EmpViewProfileBean.frmViewImage}" style="width: 300px; height: 337px; object-fit: cover;" />
						</div>
						<div class="mt-3">
							<h4>${EmpViewProfileBean.frmEmployee.firstName} ${EmpViewProfileBean.frmEmployee.lastName}</h4>
							<p class="text-secondary mb-1">${EmpViewProfileBean.frmCurrentPosition}</p>
							<p class="text-muted font-size-sm">${EmpViewProfileBean.frmEmployee.address}</p>
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
									${EmpViewProfileBean.frmEmployee.firstName}
									${EmpViewProfileBean.frmEmployee.lastName}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>Father Name:</strong>
									${EmpViewProfileBean.frmEmployee.fatherName}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>Email:</strong> ${EmpViewProfileBean.frmEmployee.email}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>Phone:</strong>
									${EmpViewProfileBean.frmEmployee.phoneNo}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>Birth Date:</strong>${EmpViewProfileBean.frmEmployee.birthDate}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>Nrc:</strong>${EmpViewProfileBean.frmEmployee.nrc}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>Gender:</strong>${EmpViewProfileBean.frmEmployee.gender}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>Address:</strong>${EmpViewProfileBean.frmEmployee.address}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>Address:</strong>${EmpViewProfileBean.frmEmployee.address}
								</div>
							</li>
						</ul>
						<div class="col-sm-12">
							<a class="btn btn-outline-info " href="empUpdatePath.do">Edit</a>
						</div>
					</div>
					<div class="portfolio-description">
						<h4>
							<font color="#836ea7">SKILLS</font>
						</h4>
						<p>
							<c:forEach items="${EmpViewProfileBean.frmSkillList}" var="list">
								<label><a href="createEmpSkill.do">${list.id.skillType.description}</a>
								</label>
								<br>
							</c:forEach>
						</p>
						<hr>
						<h4>
							<font color="#836ea7">QUALIFICATION </font>
						</h4>
						<p>
							<c:forEach items="${EmpViewProfileBean.frmQualTypeList}"
								var="list">
								<label><a href="createEmpQual.do">${list.id.qualType.description}
								</a> </label>
								<br>
							</c:forEach>
						</p>
						<hr>
						<h4>
							<font color="#836ea7">EXPERIENCES </font>
						</h4>
						<p>
							<c:forEach items="${EmpViewProfileBean.frmExperinenceList}"
								var="list">
								<label><a href="createEmpExp.do">${list.id.partyGroupPosition.positionName}
								</a> </label>
								<br>
							</c:forEach>
						</p>

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
	<c:if test="${EmpUpdateFormBean.successMsg!=null}">
		<script type="text/javascript">
			swal("Success!", "${EmpUpdateFormBean.successMsg}", "success");
		</script>
	</c:if>
</body>
</html>
