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
					<li><a class="nav-link scrollto active" href="RecruiterHome.do">Home</a>
					</li>
					<li class="dropdown"><a href="#"><span>Job Post</span> <i
							class="bi bi-chevron-down"></i> </a>
						<ul>
							<li><a href="createJobPost.do">View or Create Job Post</a></li>
						</ul>
					</li>
					<li class="dropdown"><a href="#"> <span> <!-- <img src="https://s3.eu-central-1.amazonaws.com/bootstrapbaymisc/blog/24_days_bootstrap/fox.jpg"
								width="40" height="40" class="rounded-circle"> </span> -->								
								<img src="https://s3.eu-central-1.amazonaws.com/bootstrapbaymisc/blog/24_days_bootstrap/fox.jpg"
										width="40" height="40" class="rounded-circle">
								<i class="bi bi-chevron-down"> </i> </span> </a>
						<ul>
							<li><a href="viewRecruiterProfile.do">View Profile</a></li>											
							<li><a href="recChangePasswordPath.do">Change
									Password</a>
							</li>
							<li><a href="recLoginPath.do">Log Out</a></li>	
						</ul></li>
				</ul>
				<i class="bi bi-list mobile-nav-toggle"></i>
			</nav>

		</div>
	</header>
	<!-- End Header -->
</html>