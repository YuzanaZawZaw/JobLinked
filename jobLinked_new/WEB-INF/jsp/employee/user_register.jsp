<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Registration</title>
<link rel="shortcut icon" type="image/png" href="images/gic_logo.png">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
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
	<jsp:include page="/WEB-INF//jsp/employee/employee_home_menu_bstr.jsp"></jsp:include>
	<!-- End Header -->
	<br />
	<br />
	<div class="container mt-5">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<h2 align="center">
							<font color="#836ea7">Registration</font>
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
										<html:form action="/empRegisterPath" method="post"
											enctype="multipart/form-data">
											<logic:empty property="frmRegFormControl"
												name="EmpRegFormBean">
												<div class="row mt-3">
													<div class="col-md-6">
														<html:text property="frmFirstName"
															styleClass="form-control" styleId="frmFirstName"></html:text>
													</div>
													<div class="col-md-6">
														<html:text property="frmLastName"
															styleClass="form-control" styleId="frmLastName"></html:text>
													</div>
												</div>
												<div class="mt-3">
													<html:text property="frmFatherName"
														styleClass="form-control" styleId="frmFatherName"></html:text>
												</div>
												<div class="mt-3">
													<html:text property="frmEmail" styleClass="form-control"
														styleId="frmEmail"></html:text>
												</div>
												<div class="mt-3">
													<html:password property="frmPassword"
														styleClass="form-control" styleId="frmPassword"></html:password>
												</div>
												<div class="mt-3">
													<html:text property="frmPhone" styleClass="form-control"
														styleId="frmPhone"></html:text>
												</div>
												<div class="mt-3">
													<label for="frmBirthDate">Birth Date</label>
													<html:text property="frmBirthDate" styleId="calendar"
														maxlength="10" size="15" />
													<html:image src="images/calendar.gif" styleId="trigger"
														style="cursor: pointer; border: 1px solid red;"
														title="Date selector"
														onmouseover="this.style.background='red';"
														onmouseout="this.style.background=''"></html:image>
													<font face="Verdana" size="2" color="blue">&nbsp;YYYY-MM-DD</font>
													<script type="text/javascript">
													//         
													Calendar.setup({
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
												<div class="mt-3">
													<html:text property="frmNrc" styleClass="form-control"
														styleId="frmNrc"></html:text>
												</div>
												<div class="row mt-3">
													<label class="form-check-label">Gender</label>
													<div class="col-md-6 mt-3">
														<html:radio property="frmGender" value="Male"
															styleId="frmGender">Male</html:radio>
													</div>
													<div class="col-md-6 mt-3">
														<html:radio property="frmGender" value="Female"
															styleId="frmGender">Female</html:radio>
													</div>
												</div>
												<div class="mt-3">
													<html:textarea property="frmAddress"
														styleClass="form-control" styleId="frmAddress">
													</html:textarea>
												</div>
												<div class="mt-3">
													<html:text property="frmSecurityQuest"
														styleClass="form-control" styleId="frmSecurityQuest"></html:text>
												</div>
												<div class="text-center mt-3">
													<html:submit property="btnRegister" value="Register"
														styleClass="btn btn-outline-info btn-block btn-rounded  mb-4">
													</html:submit>
													<html:cancel value="Cancel" property="btnRegisterCancel"
														styleClass="btn btn-outline-warning btn-block btn-rounded  mb-4" />
												</div>
											</logic:empty>
											<!-- Confirmation portion here -->
											<logic:notEmpty property="frmRegFormControl"
												name="EmpRegFormBean">
												<div class="row mt-3">
													<div class="col-md-6">
														<html:text property="frmFirstName"
															styleClass="form-control" disabled="true"></html:text>
													</div>
													<div class="col-md-6">
														<html:text property="frmLastName"
															styleClass="form-control" disabled="true"></html:text>
													</div>
												</div>
												<div class="mt-3">
													<html:text property="frmFatherName"
														styleClass="form-control" disabled="true"></html:text>
												</div>
												<div class="mt-3">
													<html:text property="frmEmail" styleClass="form-control"
														disabled="true"></html:text>
												</div>
												<div class="mt-3">
													<html:password property="frmPassword"
														styleClass="form-control" disabled="true"></html:password>
												</div>
												<div class="mt-3">
													<html:text property="frmPhone" styleClass="form-control"
														disabled="true"></html:text>
												</div>
												<div class="mt-3">
													<html:text property="frmBirthDate"
														styleClass="form-control" disabled="true">
													</html:text>
												</div>
												<div class="mt-3">
													<html:text property="frmNrc" styleClass="form-control"
														disabled="true"></html:text>
												</div>
												<div class="row mt-3">
													<label class="form-check-label"> Gender</label>
													<div class="col-md-6 mt-3">
														<html:radio property="frmGender" value="Male"
															disabled="true">Male</html:radio>
													</div>
													<div class="col-md-6 mt-3">
														<html:radio property="frmGender" value="Female"
															disabled="true">Female</html:radio>
													</div>
												</div>
												<div class="mt-3">
													<html:textarea property="frmAddress"
														styleClass="form-control" disabled="true">
													</html:textarea>
												</div>
												<div class="mt-3">
													<html:text property="frmSecurityQuest"
														styleClass="form-control" disabled="true"></html:text>
												</div>
												<div class="text-center mt-3">
													<html:submit property="btnSave" value="Save"
														styleClass="btn btn-outline-info btn-block btn-rounded  mb-4">
													</html:submit>
													<html:cancel value="Cancel" property="btnSaveCancel"
														styleClass="btn btn-outline-warning btn-block btn-rounded  mb-4" />
												</div>
											</logic:notEmpty>
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
              swal("Your Skill Type is has been deleted!", {
                  icon: "success",
              });
              window.location.href = href;
                                                                 
            } else {
                swal("Your data is safe!");
            }
            
          });
        });
      });
    </script>

	<!--show error message-->
	<c:if test="${EmpRegFormBean.registError!=null}">
		<script type="text/javascript">
        swal("Warning!", "${EmpRegFormBean.registError}", "warning");
      </script>
	</c:if>

	<!-- For Placehoder text -->
	<script>
		$(function() {
			$("#frmFirstName").attr("placeholder", "Enter your first name");
			$("#frmLastName").attr("placeholder", "Enter your last name");
			$("#frmFatherName").attr("placeholder", "Enter your father name");
			$("#frmEmail").attr("placeholder", "Enter your Email");
			$("#frmPassword").attr("placeholder", "Enter your Password");
			$("#frmPhone").attr("placeholder", "Enter your phone number");
			$("#frmBirthDate").attr("placeholder", "Enter your birth date");
			$("#frmNrc").attr("placeholder", "Enter your nrc");
			$("#frmGender").attr("placeholder", "Enter your gender");
			$("#frmAddress").attr("placeholder", "Enter your address");
			$("#frmSecurityQuest").attr("placeholder", "Enter...What is your dream city?");
		});
	</script>
</body>
</html>
