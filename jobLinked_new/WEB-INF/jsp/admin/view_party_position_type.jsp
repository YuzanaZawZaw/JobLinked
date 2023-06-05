<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>View Position Type</title>
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
	<div class="container">
		<div class="table-wrapper mt-5">
			<div class="table-title">
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<h2>
							<font color="#836ea7">Create Position Types</font>
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
										<html:form action="/createPositionType">
											<div class="form-group">
												<label class="form-label" for="description">Position
													Type Name:</label>
												<html:text property="frmPositionTypeName"
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
								<font color="#836ea7">Position Types</font>
							</h2>
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover table-bordered" id="myTable">
					<thead style="background-color: #836ea7; color: white">
						<tr>
							<th>Position Type Name <i class="fa fa-sort"></i>
							</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach
							items="${PositionTypeFormBean.frmPositionTypeList}"
							var="list">
							<tr>
								<td>${list.description}</td>
								<td><a
									href="deletePositionType.do?positionTypeId=${list.id}"
									class="delete" type="button"
									data-confirm="Are you sure you want to delete this position type ?"
									><i
										class="material-icons">&#xE872;</i> </a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- ======= Footer ======= -->
	<jsp:include page="/WEB-INF//jsp/inc/footer.jsp"></jsp:include>
	<!-- End Footer -->

	<jsp:include page="/WEB-INF//jsp/inc/bootstrap_script.jsp"></jsp:include>
	<!-- js alert -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<!-- for error message -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
                closeOnConfirm: false
              }).then((willDelete) => {
                event.preventDefault();         
                if (willDelete) {                                                        
                  window.location.href = href;                                                                     
                } else {
                    swal("Your data is safe!");
                }                
              });
            });       
      });
    </script>
	<!--show error message-->
	<c:if test="${PositionTypeFormBean.positionTypeNameErr!=null}">
		<script type="text/javascript">
      swal(
              "Warning!",
              "${PositionTypeFormBean.positionTypeNameErr}",
              "warning"
            );
      </script>
	</c:if>
	<!--show error message-->
	<c:if test="${PositionTypeFormBean.errorMsg!=null}">
		<script type="text/javascript">
      swal(
              "Warning!",
              "${PositionTypeFormBean.errorMsg}",
              "warning"
            );
      </script>
	</c:if>
	<!--show success message-->
	<c:if test="${PositionTypeFormBean.successMsg!=null}">
		<script type="text/javascript">
      swal(
              "Success!",
              "${PositionTypeFormBean.successMsg}",
              "success"
            );
      </script>
	</c:if>
</body>
</html>
