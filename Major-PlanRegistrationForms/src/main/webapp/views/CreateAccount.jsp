<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="ISO-8859-1">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<style>
body {
	background-image:
		url("https://ejournalz.com/wp-content/uploads/2018/11/Health-Insurance-Plan.jpg");
}
</style>

<title>Create Account</title>
</head>

<body>
	<div class="container-fluid">
		<div>
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
				<a class="navbar-brand" href="#">Health-Insurance</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a class="nav-link" href="#">Account
								Registration <span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item active"><a class="nav-link" href="#">Data
								Collection</a></li>
						<li class="nav-item dropdown active"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Admin </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/loadForm">Create Account</a> <a
									class="dropdown-item" href="/viewAccount">View Accounts</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="/loadPlanForm">Create Plan</a> <a
									class="dropdown-item" href="#">View Plans</a>
							</div></li>
					</ul>
					<form class="form-inline my-2 my-lg-0">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</button>
					</form>
				</div>
			</nav>
		</div>





		<div class="">
			<div class="row ">
				<div class="col-md-8"></div>

				<div class="col-md-4">

					<form:form action="create" modelAttribute="account" method="POST"
						class="container">
						<form:hidden path="accountId" />
						<br></br>
						<h2 align="left" style="color: black">Create Or Update Account</h2>
						<p>
							<font style="color: green"><em>${UpdateMsg}</em></font>
						</p>
						<p>
							<font style="color: green"><em>${UpdErrMsg}</em></font>
						</p>
						<p>
							<font style="color: green"><em>${msg}</em></font>
						</p>
						<p>
							<font style="color: red"><em>${errMsg}</em></font>
						</p>

						<div class="form-row mb-3">

							<label>First name</label>
							<form:input path="firstName" placeholder="First name"
								class="form-control" required="true" />
						</div>
						<div class="form-row mb-3 ">
							<label>Last name</label>
							<form:input path="lastName" placeholder="Last name"
								class="form-control" required="true" />

						</div>

						<div class="form-row mb-3">
							<label>Email Address</label>
							<form:input path="email" placeholder="Email ID"
								class="form-control" required="true" />
						</div>

						<div class="form-row mb-3">

							<label>Gender</label>
							<form:select class="custom-select" path="gender" required="true">
								<form:option value="">Choose...</form:option>
								<form:option value="Male">Male</form:option>
								<form:option value="FeMale">FeMale</form:option>
							</form:select>
						</div>

						<div class="form-row mb-3">
							<label>Role</label>
							<form:select class="custom-select" path="role" required="true">
								<form:option value="">Choose...</form:option>
								<form:option value="Case Worker">Case Worker</form:option>
								<form:option value="Admin">Admin</form:option>

							</form:select>
						</div>


						<div class="form-row mb-3">
							<button class="btn btn-md btn-primary btn-block " type="submit">Create/Update
								Account</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>

	</div>
	<!-- boot strap Js Link -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>





</body>

</html>