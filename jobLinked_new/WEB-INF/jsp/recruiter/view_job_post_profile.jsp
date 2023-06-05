<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Job post profile</title>
<link rel="shortcut icon" type="image/png" href="images/gic_logo.png">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />

<!-- MAIN BOOTSTRAP JSP -->
<jsp:include page="/WEB-INF//jsp/inc/bootstrap_link.jsp"></jsp:include>
<!-- for table style -->
<link rel="stylesheet" href="css/table_for_job_post.css" />
<style>
body {
	color: #1a202c;
	text-align: left;
	background: #f5f5f5;
	font-family: 'Roboto', sans-serif;
}
</style>
</head>
<body>
	<!-- ======= Header ======= -->
	<jsp:include page="/WEB-INF//jsp/inc/recruiter_module_header_bstr.jsp"></jsp:include>
	<!-- End Header -->
	<br>
	<br>
	<!-- ======= Job Post Profile Details Section ======= -->
	<section id="portfolio-details" class="portfolio-details">
		<div class="container mt-3">
			<div class="row">
				<div class="col-lg-4">
					<div class="portfolio-info">
						<h3>
							<font color="#836ea7">${RecViewJobPostProfileBean.frmPositionName}</font>
						</h3>
						<div>
							<strong> <c:set var="newStatus" scope="session"
									value="${RecViewJobPostProfileBean.frmStatusName}">
								</c:set> <c:if test="${newStatus=='ACTIVE'}">
									<font color="green">Currently Available</font>
								</c:if> <c:if test="${newStatus=='INACTIVE'}">
									<font color="red">Closed</font>
								</c:if> </strong>
						</div>
						<ul>
							<li><div class="d-flex justify-content-between">
									<strong>Position Name:</strong>
									${RecViewJobPostProfileBean.frmPositionName}
								</div></li>
							<li><div class="d-flex justify-content-between">
									<strong>Salary:</strong> ${RecViewJobPostProfileBean.frmSalary}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>Location:</strong>${RecViewJobPostProfileBean.frmLocation}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>Employment Type:</strong>
									<c:set var="newEmploymentType" scope="session"
										value="${RecViewJobPostProfileBean.frmEmploymentType}">
									</c:set>
									<c:if test="${newEmploymentType==1}">Full Time</c:if>
									<c:if test="${newEmploymentType==2}">Part Time</c:if>
									<c:if test="${newEmploymentType==3}">Intern Ship</c:if>
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>Start date:</strong>
									${RecViewJobPostProfileBean.frmFromDate}
								</div>
							</li>
							<li><div class="d-flex justify-content-between">
									<strong>End date:</strong>
									${RecViewJobPostProfileBean.frmThruDate}
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="col-lg-8">
					<div class="portfolio-info">
						<ul>
							<li><div class="d-flex justify-content-between">
									<strong>Recruiter Name:</strong>
									${RecViewJobPostProfileBean.frmRecruiterFirstName}
									${RecViewJobPostProfileBean.frmRecruiterLastName}
								</div>
							</li>
							<li>
								<div class="d-flex justify-content-between">
									<strong>Recruiter Phone No:</strong>
									${RecViewJobPostProfileBean.frmRecruiterPhone}
								</div></li>
							<li><div class="d-flex justify-content-between">
									<strong>Recruiter Email:</strong>
									${RecViewJobPostProfileBean.frmRecruiterEmail}
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="container-xl mt-3">
				<div class="table-responsive">
					<div class="table-wrapper">
						<div class="table-title">
							<div class="row">
								<div class="col-sm-8">
									<h3>
										<font color="#836ea7"> Applied Job Seeker List </font>
									</h3>
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
										<th>Name<i class="fa fa-sort"></i></th>
										<th>Email<i class="fa fa-sort"></i></th>
										<th>Phone<i class="fa fa-sort"></i></th>
										<th>Applied Date<i class="fa fa-sort"></i></th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach
										items="${RecViewJobPostProfileBean.frmJobPostAppliedEmployeeList}"
										var="list">
										<tr>
											<td><html:img src="${list.imagePath}" height="70"
													width="70" />
											</td>
											<td>${list.id.employee.firstName}
												${list.id.employee.lastName}</td>
											<td>${list.id.employee.email}</td>
											<td>${list.id.employee.phoneNo}</td>
											<td>${list.fromDate}</td>
											<td><a class="btn btn-outline-primary"
												href="#sendMailToEmp" data-toggle="modal">Mail</a> <a
												class="btn btn-outline-primary"
												href="cVDownload.do?frmEmployeeId=${list.id.employee.id}">DownloadCV</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</div>
				</div>
			</div>
			<div class="container-xl mt-3">
				<div class="table-responsive">
					<div class="table-wrapper">
						<div class="table-title">
							<div class="row">
								<div class="col-sm-4">
									<h3>
										<font color="#836ea7"> Requirements </font>
									</h3>
								</div>
								<div class="col-sm-6"></div>
								<div class="col-sm-2">
									<nav id="navbar" class="navbar">
										<a class="getstarted scrollto" href="#addRequirementModal"
											data-toggle="modal">New</a>
									</nav>
								</div>

							</div>
						</div>
						<div class="p-3 table-responsive">
							<table
								class="mt-3 table table-striped table-hover table-bordered"
								id="myTableReq">
								<thead style="background-color: #836ea7; color: white">
									<tr>
										<th>Requirement<i class="fa fa-sort"></i></th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach
										items="${RecViewJobPostProfileBean.frmJobPostRequirementList}"
										var="list">
										<tr>
											<td>${list.description}</td>
											<td><a
												href="deleteJobPostRequirement.do?frmJobPostRequirementId=${list.id}"
												class="delete" title="Delete" data-toggle="tooltip"
												data-confirm="Are you sure you want to delete it ?"><i
													class="material-icons">&#xE872;</i> </a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</div>
				</div>
			</div>

			<div class="container-xl mt-3">
				<div class="table-responsive">
					<div class="table-wrapper">
						<div class="table-title">
							<div class="row">
								<div class="col-sm-4">
									<h3>
										<font color="#836ea7"> Qualification </font>
									</h3>
								</div>
								<div class="col-sm-6"></div>
								<div class="col-sm-2">
									<nav id="navbar" class="navbar">
										<a class="getstarted scrollto" href="#addQualificationModal"
											data-toggle="modal">New</a>
									</nav>
								</div>

							</div>
						</div>
						<div class="p-3 table-responsive">
							<table class="table table-striped table-hover table-bordered"
								id="myTableQual">
								<thead style="background-color: #836ea7; color: white">
									<tr>
										<th>Qualification Type<i class="fa fa-sort"></i>
										<th>Qualification<i class="fa fa-sort"></i></th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach
										items="${RecViewJobPostProfileBean.frmJobPostQualList}"
										var="list2">
										<tr>
											<td>${list2.qualType.description}</td>
											<td>${list2.description}</td>
											<td><a
												href="deleteJobPostQual.do?frmJobPostQualId=${list2.id}"
												class="delete" title="Delete" data-toggle="tooltip"
												data-confirm="Are you sure you want to delete it ?"><i
													class="material-icons">&#xE872;</i> </a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Edit Qualification Modal HTML -->
	<div id="sendMailToEmp" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<html:form action="/sendMailToEmp">
					<div class="modal-header">
						<h4 class="modal-title">Mail to job seeker</h4>
						<button type="button" class="btn-close" data-dismiss="modal"></button>
					</div>
					<div class="modal-body">
						<div class="form-group first">
							<label class="form-label">To(Recipient)</label>
							<html:text property="frmMailAdd" styleClass="form-control"></html:text>
						</div>
						<div class="form-group first">
							<label class="form-label">Name</label>
							<html:text property="frmMailName" styleClass="form-control"></html:text>
						</div>
						<div class="form-group first">
							<label class="form-label">Subject</label>
							<html:text property="frmMailSubject" styleClass="form-control"></html:text>
						</div>
						<div class="form-group first">
							<label class="form-label">Compose email</label>
							<html:textarea property="frmMailBody" styleClass="form-control"
								rows="3"></html:textarea>
						</div>
						<div class="d-flex flex-column align-items-center mt-3">
							<html:submit property="btnSend" styleClass="btn btn-outline-info"
								value="Send Mail">
							</html:submit>
						</div>
					</div>
				</html:form>
			</div>
		</div>
	</div>
	<!-- Edit Requirement Modal HTML -->
	<div id="addRequirementModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<html:form action="/createJobPostRequirement">
					<div class="modal-header">
						<h4 class="modal-title">
							<font color="#836ea7">Add Requirement</font>
						</h4>
						<button type="button" class="btn-close" data-dismiss="modal"></button>
					</div>
					<div class="modal-body">
						<div class="form-group first">
							<label class="form-label">Job Post Id</label>
							<html:text property="frmJobPostId"
								value="${RecViewJobPostProfileBean.frmJobPostId}"
								styleClass="form-control" disabled="false">
							</html:text>
						</div>
						<div class="form-group first">
							<label class="form-label">Requirement Description</label>
							<html:textarea property="frmDescription"
								styleClass="form-control">
							</html:textarea>
						</div>
						<div class="d-flex flex-column align-items-center mt-3">
							<html:submit property="btnSave" value="Save"
								styleClass="btn btn-outline-info">
							</html:submit>
						</div>
					</div>
				</html:form>
			</div>
		</div>
	</div>

	<!-- Edit Qualification Modal HTML -->
	<div id="addQualificationModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<html:form action="/recCreateJobPostQual">
					<div class="modal-header">
						<h4 class="modal-title">
							<font color="#836ea7">Add Qualification</font>
						</h4>
						<button type="button" class="btn-close" data-dismiss="modal"></button>
					</div>
					<div class="modal-body">
						<div class="form-group first">
							<label class="form-label">Job Post Id</label>
							<html:text property="frmJobPostId"
								value="${RecViewJobPostProfileBean.frmJobPostId}"
								styleClass="form-control" disabled="false">
							</html:text>
						</div>
						<div class="form-group first">
							<label class="form-label">Qualification Type</label>							
							<html:select property="frmQualType" styleClass="form-select">
								<%int i = 1;%>
								<html:option value="0">SELECT</html:option>							
								<c:forEach items="${RecViewJobPostProfileBean.qualList}"
									var="list3">
									<%-- <c:set var="qualificationList" value="${list3.description}" /> --%>
									<html:option value="${list3.id}">${list3.description}</html:option>
								</c:forEach>								
							</html:select>
						</div>
						<div class="form-group first">
							<label class="form-label">Qualification Description</label>
							<html:textarea property="frmDescription"
								styleClass="form-control">
							</html:textarea>
						</div>
						<div class="d-flex flex-column align-items-center mt-3">
							<html:submit property="btnSave" value="Save"
								styleClass="btn btn-outline-info">
							</html:submit>
						</div>
					</div>
				</html:form>
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

	<!-- for modal -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

	<!-- for data table -->
	<jsp:include page="/WEB-INF//jsp/inc/data_table_qual.jsp"></jsp:include>
	<jsp:include page="/WEB-INF//jsp/inc/data_table_req.jsp"></jsp:include>
	<jsp:include page="/WEB-INF//jsp/inc/data_table_col4.jsp"></jsp:include>


	<c:if test="${MailFormBean.frmMailMessage!=null}">
		<script type="text/javascript">
			swal("Success!", "${MailFormBean.frmMailMessage}", "success");
		</script>
	</c:if>
	<c:if test="${MailFormBean.frmMailFailMessage!=null}">
		<script type="text/javascript">
			swal("Warning!", "${MailFormBean.frmMailFailMessage}", "warning");
		</script>
	</c:if>
	<c:if test="${CVFormBean.successMsg!=null}">
		<script type="text/javascript">
			swal("Success!", "${CVFormBean.successMsg}", "success");
		</script>
	</c:if>
	<c:if test="${CVFormBean.errorMsg!=null}">
		<script type="text/javascript">
			swal("Warning!", "${CVFormBean.errorMsg}", "warning");
		</script>
	</c:if>
	<c:if test="${RecJobPostRequirementBean.successMsg!=null}">
		<script type="text/javascript">
			swal("Success!", "${RecJobPostRequirementBean.successMsg}",
					"success");
		</script>
	</c:if>
	<c:if test="${RecJobPostQualBean.successMsg!=null}">
		<script type="text/javascript">
			swal("Success!", "${RecJobPostQualBean.successMsg}", "success");
		</script>
	</c:if>
	<script type="text/javascript">
	$(document).ready(function () {   	
        $("[data-confirm]").on("click", function (e) {
          e.preventDefault(); //cancel default action

          //Recuperate href value
          var href = $(this).attr("href");
          var message = $(this).data("confirm");

          //pop up
          swal({
            title: "Are you sure ??",
            text: message,
            icon: "warning",
            buttons: true,
            dangerMode: true,
            closeOnConfirm: false,
            closeOnClickOutside: false,
            timer: 2000,
          }).then((willDelete) => {
            e.preventDefault();         
            if (willDelete) {                                     
              window.location.href = href;                                                                 
            } else {
                swal("Your data is safe!");
            }           
          });
        });
      });
    </script>
</body>
</html>