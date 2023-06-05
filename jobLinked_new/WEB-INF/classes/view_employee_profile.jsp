<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>View Profile</title>
<link rel="shortcut icon" type="image/png" href="images/gic_logo.png">
<!-- 
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">


<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	 -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">	 
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
/* body {
	margin-top: 20px;
	color: #1a202c;
	text-align: left;
	background-color: #e2e8f0;
}

.main-body {
	padding: 15px;
}

.card {
	box-shadow: 0 1px 3px 0 rgba(0, 0, 0, .1), 0 1px 2px 0
		rgba(0, 0, 0, .06);
}

.card {
	position: relative;
	display: flex;
	flex-direction: column;
	min-width: 0;
	word-wrap: break-word;
	background-color: #fff;
	background-clip: border-box;
	border: 0 solid rgba(0, 0, 0, .125);
	border-radius: .25rem;
}

.card-body {
	flex: 1 1 auto;
	min-height: 1px;
	padding: 1rem;
}

.gutters-sm {
	margin-right: -8px;
	margin-left: -8px;
}

.gutters-sm>.col,.gutters-sm>[class *=col-] {
	padding-right: 8px;
	padding-left: 8px;
}

.mb-3,.my-3 {
	margin-bottom: 1rem !important;
}

.bg-gray-300 {
	background-color: #e2e8f0;
}

.h-100 {
	height: 100% !important;
}

.shadow-none {
	box-shadow: none !important;
} */
</style>
<body>
	<!-- ======= Header ======= -->
	<jsp:include page="/WEB-INF//jsp/inc/employee_module_header_bstr.jsp"></jsp:include>
	<!-- End Header -->
	<br>
	<br>
	<div class="container mt-5">
		<div class="main-body">
			<div class="row gutters-sm">
				<div class="col-md-4 mb-3">
					<div class="card">
						<div class="card-body">
							<div class="d-flex flex-column align-items-center text-center">
								<div class="profile-img">
									<html:img src="${EmpViewProfileBean.frmViewImage}" width="150"
										alt="Profile" styleClass="rounded-circle mt-5" />
								</div>
								<div class="mt-3">
									<h4>${EmpViewProfileBean.frmEmployee.firstName}</h4>
									<p class="text-secondary mb-1">${EmpViewProfileBean.frmCurrentPosition}</p>
									<p class="text-muted font-size-sm">${EmpViewProfileBean.frmEmployee.address}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="card mt-3">
						<div class="card h-100">
							<div class="card-body">
								<h6 class="d-flex align-items-center mb-3">SKILLS</h6>
								<c:forEach items="${EmpViewProfileBean.frmSkillList}" var="list">
									<label><a href="createEmpSkill.do">${list.id.skillType.description}</a>
									</label>
									<br>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-8">
					<div class="card mb-3">
						<div class="card-body">
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Full Name</h6>
								</div>
								<div class="col-sm-9 text-secondary">${EmpViewProfileBean.frmEmployee.firstName}
									${EmpViewProfileBean.frmEmployee.lastName}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Father Name</h6>
								</div>
								<div class="col-sm-9 text-secondary">${EmpViewProfileBean.frmEmployee.fatherName}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Email</h6>
								</div>
								<div class="col-sm-9 text-secondary">${EmpViewProfileBean.frmEmployee.email}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Phone</h6>
								</div>
								<div class="col-sm-9 text-secondary">${EmpViewProfileBean.frmEmployee.phoneNo}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Birth Date</h6>
								</div>
								<div class="col-sm-9 text-secondary">${EmpViewProfileBean.frmEmployee.birthDate}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Nrc</h6>
								</div>
								<div class="col-sm-9 text-secondary">${EmpViewProfileBean.frmEmployee.nrc}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Gender</h6>
								</div>
								<div class="col-sm-9 text-secondary">${EmpViewProfileBean.frmEmployee.gender}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Address</h6>
								</div>
								<div class="col-sm-9 text-secondary">${EmpViewProfileBean.frmEmployee.address}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-12">
									<a class="btn btn-info " href="empUpdatePath.do">Edit</a>
								</div>
							</div>
						</div>
					</div>
					<div class="row gutters-sm">
						<div class="col-sm-6 mb-3">
							<div class="card h-100">
								<div class="card-body">
									<h6 class="d-flex align-items-center mb-3">QUALIFICATION</h6>
									<c:forEach items="${EmpViewProfileBean.frmQualTypeList}"
										var="list">
										<label><a href="createEmpQual.do">${list.id.qualType.description}
										</a> </label>
										<br>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="col-sm-6 mb-3">
							<div class="card h-100">
								<div class="card-body">
									<h6 class="d-flex align-items-center mb-3">EXPERIENCES</h6>
									<c:forEach items="${EmpViewProfileBean.frmExperinenceList}"
										var="list">
										<label><a href="createEmpExp.do">${list.id.partyGroupPosition.positionName}
										</a> </label>
										<br>
									</c:forEach>
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
	
</body>