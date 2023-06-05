<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>View Skill</title>
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
	<div class="container mt-5">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<h2>
							<font color="#836ea7">Create Skill</font>
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
										<html:form action="/createEmpSkill">
											<%-- <div class="form-group first">
												<html:errors property="frmSkillTypeName" />
												<html:errors property="frmSkillLevel" /> 
											</div> --%>											
											<div class="form-group first">
												<label class="form-label" for="description">Skill
													Type Name:</label>
												<html:select property="frmSkillTypeName"
													styleClass="form-select">
													<html:option value="0">SELECT</html:option>
													<html:optionsCollection property="frmSkillTypeList"
														value="id" label="description" />
												</html:select>
											</div>
											<div class="form-group first">
												<label class="form-label" for="description">Skill
													Level:</label>
												<html:text property="frmSkillLevel"
													styleClass="form-control">
												</html:text>
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
								<font color="836ea7">Skill Details</font>
							</h2>
						</div>
					</div>
				</div>
				<div class="p-3 table-responsive">
					<table class="table table-striped table-hover table-bordered"
						id="myTable">
						<thead style="background-color: #836ea7">
							<tr>
								<th><font color="white">Skill Type Name <i
										class="fa fa-sort"></i> </font></th>
								<th><font color="white">Skill Level <i
										class="fa fa-sort"></i> </font></th>
								<th><font color="white">Action</font></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach
								items="${sessionScope.EmpProfileSkillBean.frmDetailEmpSkillList}"
								var="list">
								<tr>
									<td>${list.id.skillType.description}</td>
									<td>${list.skillLevel}</td>
									<td><a
										href="deleteEmpSkill.do?frmEmployeeId=${list.id.employee.id}&&frmSkillTypeId=${list.id.skillType.id}"
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
	<jsp:include page="/WEB-INF//jsp/inc/data_table_col1.jsp"></jsp:include>
	
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
              /* swal("Your Skill is has been deleted!", {
                  icon: "success",
              }); */
              window.location.href = href;
                                                                 
            } else {
                swal("Your data is safe!");
            }           
          });
        });
      });
    </script>
    <!--show error message-->
	<c:if test="${EmpProfileSkillBean.frmSkillTypeNameErr!=null}">
		<script type="text/javascript">
        swal("Warning!", "${EmpProfileSkillBean.frmSkillTypeNameErr}", "warning");
      </script>
	</c:if>
	<c:if test="${EmpProfileSkillBean.frmSkillLevelErr!=null}">
		<script type="text/javascript">
        swal("Warning!", "${EmpProfileSkillBean.frmSkillLevelErr}", "warning");
      </script>
	</c:if>
	<c:if test="${EmpProfileSkillBean.errorMsg!=null}">
		<script type="text/javascript">
        swal("Warning!", "${EmpProfileSkillBean.errorMsg}", "warning");
      </script>
	</c:if>
	<!--show success message-->
	<c:if test="${EmpProfileSkillBean.successMsg!=null}">
		<script type="text/javascript">
        swal("Success!", "${EmpProfileSkillBean.successMsg}", "success");
      </script>
	</c:if>
	<!--show success message-->
	<c:if test="${EmpProfileSkillBean.deleteSuccessMsg!=null}">
		<script type="text/javascript">
        swal("Success!", "${EmpProfileSkillBean.deleteSuccessMsg}", "success");
      </script>
	</c:if>
</body>
</html>