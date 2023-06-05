<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>View Qualification</title>

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
	<jsp:include page="/WEB-INF//jsp/inc/employee_module_header_bstr.jsp"></jsp:include>
	<!-- End Header -->
	<br />
	<br />
	<div class="container mt-5">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<h2>
							<font color="#836ea7">Create Qualification</font>
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
										<html:form action="/createEmpQual">
											<div class="form-group first">
												<label class="form-label" for="description">Qualification
													Type Name:</label>
												<html:select property="frmQualTypeName"
													styleClass="form-select">
													<html:option value="0">SELECT</html:option>
													<html:optionsCollection property="frmQualTypeList"
														value="id" label="description" />
												</html:select>
											</div>
											<div class="form-group first">
												<label class="form-label" for="description">School
													Name:</label>
												<html:text property="frmSchoolName"
													styleClass="form-control">
												</html:text>
											</div>
											<div class="form-group first">
												<label class="form-label" for="description">Degree:</label>
												<html:text property="frmDegree" styleClass="form-control">
												</html:text>
											</div>
											<div class="form-group first">
												<label class="form-label" for="description">Field Of
													Study:</label>
												<html:text property="frmFieldOfStudy"
													styleClass="form-control">
												</html:text>
											</div>
											<div class="form-group first">
												<label class="form-label" for="description">Field Of
													Activity:</label>
												<html:text property="frmFieldOfActivity"
													styleClass="form-control">
												</html:text>
											</div>
											<div class="form-group first">
												<label class="form-label" for="description">Start
													Date:</label>
												<html:text property="frmFromDate" styleId="calendar"
													maxlength="10" size="15" />
												<html:image src="images/calendar.gif" styleId="trigger"
													style="cursor: pointer; border: 1px solid red;"
													title="Date selector"
													onmouseover="this.style.background='red';"
													onmouseout="this.style.background=''"></html:image>
												<font face="Verdana" size="2" color="#836ea7">&nbsp;YYYY-MM-DD</font>
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
												<label class="form-label" for="description">End Date
													(expected):</label>
												<html:text property="frmThruDate" styleId="calendar1"
													maxlength="10" size="15" />
												<html:image src="images/calendar.gif" styleId="trigger1"
													style="cursor: pointer; border: 1px solid red;"
													title="Date selector"
													onmouseover="this.style.background='red';"
													onmouseout="this.style.background=''"></html:image>
												<font face="Verdana" size="2" color="#836ea7">&nbsp;YYYY-MM-DD</font>
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
								<font color="836ea7">Qualification Details</font>
							</h2>
						</div>
					</div>
				</div>
				<div class="p-3 table-responsive">
					<table class="table table-striped table-hover table-bordered"
						id="myTable">
						<thead style="background-color: #836ea7">
							<tr>
								<th><font color="white">Qualification Type Name <i
										class="fa fa-sort"></i> </font>
								</th>
								<th><font color="white">School Name <i
										class="fa fa-sort"></i> </font>
								</th>
								<th><font color="white">Degree <i class="fa fa-sort"></i>
								</font>
								</th>
								<th><font color="white">Field Of Study <i
										class="fa fa-sort"></i> </font>
								</th>
								<th><font color="white">Field Of Activity <i
										class="fa fa-sort"></i> </font>
								</th>
								<th><font color="white">Start Date <i
										class="fa fa-sort"></i> </font>
								</th>
								<th><font color="white">End Date (or Expected) <i
										class="fa fa-sort"></i> </font>
								</th>
								<th><font color="white">Action</font></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach
								items="${sessionScope.EmpProfileQualBean.frmDetailEmpQualList}"
								var="list">
								<tr>
									<td>${list.id.qualType.description}</td>
									<td>${list.schoolName}</td>
									<td>${list.degree}</td>
									<td>${list.fieldOfStudy}</td>
									<td>${list.fieldOfActivity}</td>
									<td>${list.fromDate}</td>
									<td>${list.thruDate}</td>
									<td><a
										href="deleteEmpQual.do?frmEmployeeId=${list.id.employee.id}&&frmQualTypeId=${list.id.qualType.id}"
										class="delete" title="Delete"
										data-confirm="Are you sure you want to delete this skill?"><i
											class="material-icons">&#xE872;</i> </a></td>
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
	<jsp:include page="/WEB-INF//jsp/inc/data_table_col7.jsp"></jsp:include>
	
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
    <!--show success message-->
	<c:if test="${EmpProfileQualBean.deleteSuccessMsg!=null}">
		<script type="text/javascript">
        swal("Success!", "${EmpProfileQualBean.deleteSuccessMsg}", "success");
      </script>
	</c:if>
	<c:if test="${EmpProfileQualBean.errorMsg!=null}">
		<script type="text/javascript">
        swal("Warning!", "${EmpProfileQualBean.errorMsg}", "warning");
      </script>
	</c:if>
	<c:if test="${EmpProfileQualBean.successMsg!=null}">
		<script type="text/javascript">
        swal("Success!", "${EmpProfileQualBean.successMsg}", "success");
      </script>
	</c:if>
	<!--show error message-->
	<c:if test="${EmpProfileQualBean.frmQualTypeNameErr!=null}">
		<script type="text/javascript">
        swal("Warning!", "${EmpProfileQualBean.frmQualTypeNameErr}", "warning");
      </script>
	</c:if>
	<c:if test="${EmpProfileQualBean.frmSchoolNameErr!=null}">
		<script type="text/javascript">
        swal("Warning!", "${EmpProfileQualBean.frmSchoolNameErr}", "warning");
      </script>
	</c:if>
	<c:if test="${EmpProfileQualBean.frmDegreeErr!=null}">
		<script type="text/javascript">
        swal("Warning!", "${EmpProfileQualBean.frmDegreeErr}", "warning");
      </script>
	</c:if>
	<c:if test="${EmpProfileQualBean.frmFieldOfStudyErr!=null}">
		<script type="text/javascript">
        swal("Warning!", "${EmpProfileQualBean.frmFieldOfStudyErr}", "warning");
      </script>
	</c:if>
	<c:if test="${EmpProfileQualBean.frmFieldOfActivityErr!=null}">
		<script type="text/javascript">
        swal("Warning!", "${EmpProfileQualBean.frmFieldOfActivityErr}", "warning");
      </script>
	</c:if>
	<c:if test="${EmpProfileQualBean.frmFromDateErr!=null}">
		<script type="text/javascript">
        swal("Warning!", "${EmpProfileQualBean.frmFromDateErr}", "warning");
      </script>
	</c:if>
	<c:if test="${EmpProfileQualBean.frmThruDateErr!=null}">
		<script type="text/javascript">
        swal("Warning!", "${EmpProfileQualBean.frmThruDateErr}", "warning");
      </script>
	</c:if>
</body>
</html>