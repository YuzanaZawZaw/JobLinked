<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>View Job Seeker List</title>
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
	<jsp:include page="/WEB-INF//jsp/inc/admin_module_header_bstr.jsp"></jsp:include>
	<!-- End Header -->
	<br />
	<br />

	<div class="container-xl">
		<div class="table-responsive">
			<div class="table-wrapper">

				<div class="table-title">
					<div class="row">
						<div class="col-sm-6">
							<h2>
								<font color="#836ea7">View Job Seeker List</font>
							</h2>
						</div>
					</div>
				</div>
				<div class="p-3 table-responsive">
					<table class="table table-striped table-hover table-bordered"
						id="myTable">
						<thead style="background-color: #836ea7; color: white">
							<tr>
								<th>Profile <i class="fa fa-sort"></i>
								</th>
								<th>Name <i class="fa fa-sort"></i>
								</th>
								<th>Address <i class="fa fa-sort"></i>
								</th>
								<th>Email <i class="fa fa-sort"></i>
								</th>
								<th>Gender <i class="fa fa-sort"></i>
								</th>
								<th>Phone <i class="fa fa-sort"></i>
								</th>
								<th>Status <i class="fa fa-sort"></i>
								</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${sessionScope.EmployeeListBean.employeeList}"
								var="list">

								<tr>
									<td><html:img src="${list.imagePath}" height="70"
											width="70" />
									</td>
									<td><font color="#836ea7">${list.firstName}
											${list.lastName}</font>
									</td>
									<td><i class="zmdi zmdi-pin mr-2"></i> ${list.address}</td>
									<td><i class="zmdi zmdi-email"></i> ${list.email}</td>
									<td><i class="zmdi zmdi-face"></i> ${list.gender}</td>
									<td><i class="zmdi zmdi-code-smartphone"></i>
										${list.phoneNo}</td>
									<td><i class="zmdi zmdi-notifications"></i>
										${list.status.description}</td>
									<td>
										<c:if test="${list.status.description =='ACTIVE'}">
											<a href="deactivateEmpAccount.do?frmEmployeeId=${list.id}"
												class="btn d-block w-100 d-sm-inline-block btn-outline-danger btn-sm"
												data-confirm="Are you sure you want to deactivate this account ?">

												<i class="zmdi zmdi-alert-octagon"></i>Deactivate</a>
										</c:if> 
										<c:if test="${list.status.description =='INACTIVE'}">
											<a href="activateEmpAccount.do?frmEmployeeId=${list.id}"
												class="btn d-block w-100 d-sm-inline-block btn-outline-success btn-sm"
												data-confirm="Are you sure you want to activate this account ?">
												<i class="zmdi zmdi-alert-octagon"></i>Activate</a>
										</c:if>
									</td>
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

	<!--for confirm message -->
	<jsp:include page="/WEB-INF//jsp/inc/activate_deactivate.jsp"></jsp:include>

	<!-- for error message -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

	<!-- js alert -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

	<!-- for data table -->
	<jsp:include page="/WEB-INF//jsp/inc/data_table_col7.jsp"></jsp:include>

	<!--show success message-->
	<c:if test="${EmployeeListBean.successMsg!=null}">
		<script type="text/javascript">
			swal("Success!", "${EmployeeListBean.successMsg}", "success");
		</script>
	</c:if>
</body>
</html>
