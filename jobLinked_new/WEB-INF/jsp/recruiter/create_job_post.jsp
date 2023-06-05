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
							<font color="#836ea7">Create a job post</font>
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
										<html:form action="/createJobPost">
											<div class="form-group first">
												<label class="form-label" for="positionName">Position
													Name:</label>
												<html:select property="frmPositionName"
													styleClass="form-select">
													<html:option value="0">SELECT</html:option>
													<html:optionsCollection property="frmPositionList"
														value="id" label="positionName" />
												</html:select>
											</div>
											<div class="form-group first">
												<label class="form-label" for="status">Status:</label>
												<html:select property="frmStatusName"
													styleClass="form-select">
													<html:option value="0">SELECT</html:option>
													<html:optionsCollection property="frmStatusList" value="id"
														label="description" />

												</html:select>
											</div>
											<div class="form-group first">
												<label class="form-label" for="location">Location:</label>
												<html:text property="frmLocation" styleClass="form-control">
												</html:text>
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
												<label class="form-label" for="salary">Salary:</label>
												<html:text property="frmSalary" styleClass="form-control">
												</html:text>
											</div>
											<div class="form-group first">
												<label class="form-label" for="salary">Start Date:</label>
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
												<label class="form-label" for="salary">End Date:</label>
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
											<div class="d-flex flex-column align-items-center mt-3">
												<html:submit property="btnSave" value="Save"
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
	<div class="container-xl">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-sm-8">
							<h2>
								<font color="836ea7">Job post list</font>
							</h2>
						</div>
					</div>
				</div>
				<div class="p-3 table-responsive">
					<table class="table table-striped table-hover table-bordered"
						id="myTable">
						<thead style="background-color: #836ea7">
							<tr>
								<!-- <th># <i class="fa fa-sort"></i></th>		 -->
								<th><font color="white">Position Name <i
										class="fa fa-sort"></i>
								</font></th>
								<th><font color="white">Company Name <i
										class="fa fa-sort"></i>
								</font></th>
								<th><font color="white">Recruiter Name <i
										class="fa fa-sort"></i>
								</font></th>
								<th><font color="white">Status <i class="fa fa-sort"></i>
								</font></th>
								<th><font color="white">Employment Type <i
										class="fa fa-sort"></i>
								</font></th>
								<th><font color="white">Location <i
										class="fa fa-sort"></i>
								</font></th>
								<th><font color="white">Salary<i class="fa fa-sort"></i>
								</font></th>

								<th><font color="white">Start Date <i
										class="fa fa-sort"></i>
								</font></th>
								<th><font color="white">End Date(or Expected) <i
										class="fa fa-sort"></i>
								</font></th>
								<th><font color="white">Action</font>
								</th>
							</tr>
						</thead>
						<tbody>
							<%-- <%
								int i = 1;
							%> --%>
							<c:forEach items="${RecJobPostBean.frmJobPostList}" var="list">

								<tr>
									<%-- <td><%=i++%></td> --%>
									<td>${list.partyGroupPosition.positionName}</td>
									<td>${list.partyGroupPosition.partyGroup.groupNameLocal}</td>
									<td>${list.recruiter.firstName} ${list.recruiter.lastName}</td>
									<td>${list.status.description}</td>
									<td><c:set var="newEmploymentType" scope="session"
											value="${list.employmentType}">
										</c:set> <c:if test="${newEmploymentType==1}">
										Full Time
								</c:if> <c:if test="${newEmploymentType==2}">
										Part Time
								</c:if> <c:if test="${newEmploymentType==3}">
										Intern Ship
								</c:if></td>
									<td>${list.location}</td>
									<td>${list.salary}</td>
									<td>${list.fromDate}</td>
									<td>${list.thruDate}</td>
									<c:if test="${list.status.description =='ACTIVE'}">
										<td><a
											href="viewJobPostProfile.do?frmJobPostId=${list.id}"
											class="view" title="View" data-toggle="tooltip"><i
												class="material-icons">&#xE417;</i> </a> <a
											href="updateJobPost.do?frmJobPostId=${list.id}" class="edit"
											title="Edit" data-toggle="tooltip"><i
												class="material-icons">&#xE254;</i> </a> <a
											href="deleteJobPost.do?frmJobPostId=${list.id}"
											class="delete" title="Delete" data-toggle="tooltip"
											data-confirm="Are you sure you want to delete this job post ?"><i
												class="material-icons">&#xE872;</i> </a></td>
									</c:if>
									<c:if test="${list.status.description =='INACTIVE'}">
										<td><a
											href="viewJobPostProfile.do?frmJobPostId=${list.id}"
											class="view" title="View" data-toggle="tooltip"><i
												class="material-icons">&#xE417;</i> </a> <a
											href="updateJobPost.do?frmJobPostId=${list.id}" class="edit"
											title="Edit" data-toggle="tooltip"><i
												class="material-icons">&#xE254;</i> </a></td>
									</c:if>
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
	<jsp:include page="/WEB-INF//jsp/inc/data_table_col8.jsp"></jsp:include>

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

	<c:if test="${RecJobPostBean.successMsg!=null}">
		<script type="text/javascript">
        swal("Success!", "${RecJobPostBean.successMsg}", "success");
      </script>
	</c:if>
	<!--show error message-->
	<c:if test="${RecJobPostBean.errorMsg!=null}">
		<script type="text/javascript">
        swal("Warning!", "${RecJobPostBean.errorMsg}", "warning");
      </script>
	</c:if>
</body>
</html>