<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="shortcut icon" type="image/png" href="images/gic_logo.png">
</head>
<body>

	<!-- ======= Header ======= -->
	<header id="header" class="d-flex align-items-center">
		<div class="container d-flex align-items-center">
			<h1 class="logo me-auto">
				<a href="#">Job Linked</a>
			</h1>
			<nav id="navbar" class="navbar">
				<ul>
					<li><a class="nav-link scrollto active" href="EmployeeHome.do">Home</a>
					</li>
					<li class="dropdown"><a href="#"><span>Job Post</span> <i
							class="bi bi-chevron-down"></i> </a>
						<ul>
							<li><a href="viewJobPostList.do">Apply Job Posts</a>
							</li>
							<li><a href="viewAppliedJobPostList.do">View Applied Job
									Posts</a>
							</li>
						</ul></li>
					<li class="dropdown">
					<a href="#"> <span> 
					<!-- <img src="https://s3.eu-central-1.amazonaws.com/bootstrapbaymisc/blog/24_days_bootstrap/fox.jpg"
								width="40" height="40" class="rounded-circle"> </span> --> 
							<c:if test="${EmpLoginFormBean.frmViewImage!=null}">
								<html:img src="${EmpLoginFormBean.frmViewImage}"
									alt="Profile" width="45" height="55" styleClass="rounded-circle" />
							</c:if> 
							<c:if test="${EmpLoginFormBean.frmViewImage==null}">
								<img src="https://s3.eu-central-1.amazonaws.com/bootstrapbaymisc/blog/24_days_bootstrap/fox.jpg"
								width="40" height="40" class="rounded-circle">
							</c:if>
							<i class="bi bi-chevron-down">
							</i> 
							 </span>
							 </a>
						<ul>
							<li><a href="employeeViewProfile.do">View Profile</a>
							</li>
							<li><a href="employeeChangePasswordPath.do">Change
									Password</a>
							</li>
							<li><a href="createEmpSkill.do">Create Skills</a>
							</li>
							<li><a href="createEmpQual.do">Create Qualifications</a>
							</li>
							<li><a href="createEmpExp.do">Create Work Experiences</a>
							</li>
							<li><a href="empLoginPath.do">Log Out</a>
							</li>
						</ul>
					</li>
				</ul>
				<i class="bi bi-list mobile-nav-toggle"></i>
			</nav>

		</div>
	</header>
	<!-- End Header -->
</html>