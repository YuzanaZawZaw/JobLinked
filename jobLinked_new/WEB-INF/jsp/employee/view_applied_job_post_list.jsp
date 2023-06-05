<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>View Applied Job Post List</title>
<link rel="shortcut icon" type="image/png" href="images/gic_logo.png">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />

<!-- MAIN BOOTSTRAP JSP -->
<jsp:include page="/WEB-INF//jsp/inc/bootstrap_link.jsp"></jsp:include>

<!-- for table style -->
<link rel="stylesheet" href="css/tables.css" />

</head>
<body>
	<!-- ======= Header ======= -->
	<jsp:include page="/WEB-INF//jsp/inc/employee_module_header_bstr.jsp"></jsp:include>
	<!-- End Header -->
	<br />
	<br />
	<div class="container-xl">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-sm-8">
							<h2>
								<font color="#836ea7">Applied Job Posts</font>
							</h2>
						</div>
					</div>
				</div>
				<div class="p-3 table-responsive">
					<table class="table table-striped table-hover table-bordered"
						id="myTable">
						<thead style="background-color: #836ea7; color: white">
							<tr>
								<th>Position Name <i class="fa fa-sort"></i></th>
								<th>Location <i class="fa fa-sort"></i></th>
								<th>Company Name <i class="fa fa-sort"></i></th>
								<th>Salary <i class="fa fa-sort"></i></th>
								<th>Employment Type <i class="fa fa-sort"></i></th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach
										items="${sessionScope.EmpViewAppliedJobPostListBean.frmJobPostList}"
										var="list">
								<tr>
									<td>${list.partyGroupPosition.positionName}</td>
									<td>${list.location}</td>
									<td>${list.partyGroupPosition.partyGroup.groupNameLocal}</td>
									<td>${list.salary}</td>
									<c:set var="newEmploymentType" scope="session"
										value="${list.employmentType}">
									</c:set>
									<c:if test="${newEmploymentType==1}">
										<td>Full Time</td>
									</c:if>
									<c:if test="${newEmploymentType==2}">
										<td>Part Time</td>
									</c:if>
									<c:if test="${newEmploymentType==3}">
										<td>Intern Ship</td>
									</c:if>									
									<td>
									<a class="btn d-block w-100 d-sm-inline-block btn-outline-info btn-sm"
														href="viewJobPostFromEmp.do?frmJobPostId=${list.id}"><font
														color="#836ea7">View</font> </a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
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

	<!-- for data table -->
	<jsp:include page="/WEB-INF//jsp/inc/data_table_col5.jsp"></jsp:include>

</body>
</html>
