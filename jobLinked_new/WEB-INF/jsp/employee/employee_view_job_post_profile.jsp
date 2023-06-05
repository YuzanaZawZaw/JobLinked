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
						<h3><font color="#836ea7">${EmpViewJobPostProfileBean.frmJobPost.partyGroupPosition.positionName}</font>
						</h3>
						<div>
							<strong> 
							<c:set var="newStatus" scope="session"
										value="${EmpViewJobPostProfileBean.frmJobPost.status.description}">
							</c:set>
							<c:if test="${newStatus=='ACTIVE'}">
									<font color="green">Currently Available</font>
								</c:if> <c:if test="${newStatus=='INACTIVE'}">
									<font color="red">Closed</font>
								</c:if> </strong>
						</div>
						<ul>
							<li><div class="d-flex justify-content-between">
									<strong>Position Name:</strong>
									${EmpViewJobPostProfileBean.frmJobPost.partyGroupPosition.positionName}
								</div></li>
							<li><div class="d-flex justify-content-between">
									<strong>Salary:</strong>
									${EmpViewJobPostProfileBean.frmJobPost.salary}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>Start date:</strong>
									${EmpViewJobPostProfileBean.frmJobPost.fromDate}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>End date:</strong>
									${EmpViewJobPostProfileBean.frmJobPost.thruDate}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>Company Name:</strong>${sessionScope.EmpViewJobPostProfileBean.frmJobPost.partyGroupPosition.partyGroup.groupNameLocal}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>Location:</strong>${EmpViewJobPostProfileBean.frmJobPost.location}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>Employment Type:</strong>
									<c:set var="newEmploymentType" scope="session"
										value="${sessionScope.EmpViewJobPostProfileBean.frmJobPost.employmentType}">
									</c:set>
									<c:if test="${newEmploymentType==1}">Full Time</c:if>
									<c:if test="${newEmploymentType==2}">Part Time</c:if>
									<c:if test="${newEmploymentType==3}">Intern Ship</c:if>
								</div></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-8">
					<div class="portfolio-info">
						<ul>
							<li><div class="d-flex justify-content-between">
									<strong>Recruiter Name:</strong>
									${EmpViewJobPostProfileBean.frmRecruiter.firstName}
									${EmpViewJobPostProfileBean.frmRecruiter.lastName}
								</div>
							</li>
							<li>
								<div class="d-flex justify-content-between">
									<strong>Recruiter Phone No:</strong>
									${EmpViewJobPostProfileBean.frmRecruiter.phoneNo}
								</div></li>
							<li><div class="d-flex justify-content-between">
									<strong>Recruiter Email:</strong>
									${EmpViewJobPostProfileBean.frmRecruiter.email}
								</div>
							</li>
						</ul>
					</div>
					<div class="portfolio-description">
						<h3><font color="#836ea7">
							Requirements for
							${EmpViewJobPostProfileBean.frmJobPost.partyGroupPosition.positionName}</font>
						</h3>
						<p>
							<c:forEach
								items="${EmpViewJobPostProfileBean.frmJobPostRequirementList}"
								var="list">
										- ${list.description}<br>
							</c:forEach>
						</p>
						<hr>
						<h3><font color="#836ea7">Qualification for
							${EmpViewJobPostProfileBean.frmJobPost.partyGroupPosition.positionName}
							</font>
						</h3>
						<p>
							<c:forEach
								items="${EmpViewJobPostProfileBean.frmJobPostQualList}"
								var="qualList">
										- ${qualList.qualType.description}  ${qualList.description}<br>
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

</body>
</html>
