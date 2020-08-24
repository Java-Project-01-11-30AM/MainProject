<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(event) {
		$("#countryId").change(function() {
			$("#stateId").find('option').remove();
			$('<option>').val('').text('-Select-').appendTo("#stateId");
			
			$("#cityId").find('option').remove();
			$('<option>').val('').text('-Select').appendTo("#cityId");
			
			var countryId = $("#countryId").val();
			$.ajax({
				type : "GET",
				url : "getStates?cid=" + countryId,
				success : function(data) {
					$.each(data, function(key, value) {
						$('<option>').val(key).text(value).appendTo("#stateId");
					});
				}
			});
		});
		
		
		$("#stateId").change(function() {
			$("#cityId").find('option').remove();
			$('<option>').val('').text('-Select-').appendTo("#cityId");
			var stateId = $("#stateId").val();
			$.ajax({
				type : "GET",
				url : "getCities?sid=" + stateId,
				success : function(data) {
					$.each(data, function(key, value) {
						$('<option>').val(key).text(value)
											  .appendTo("#cityId");
					});
				}
			});
		});
		
		
	});
	$(document).ready(function(e){
		 $("#email").blur(function(event){
			 $("#dupEmail").html("");
			 var emailId = $("#email").val();
			 $.ajax({
				 url:'validateEmail?email='+ emailId,
						 success: function(abc){
							 if(abc== 'Duplicate'){
								 $("#dupEmail").html("Email already registered");
								 $("#email").focus();
							 }
						 }
			 });
			 
		 });
	 });
</script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
  border: 2px solid black;
   padding: 8px;
   align: center;
}
table.center {
  margin-left:auto; 
  margin-right:auto;
}
</style>
</head>
<body style="background-image: url('images/regform2.jpg'); ">

	<h1 style="text-align:center;">Registration Page</h1>
     <h2 style="text-align:center;"> Create Account </h2> 
     
	<form:form action="userAccReg" method="post" modelAttribute="userAcc">
	<div class="a-box-inner">
		<table class= "center" style="align: center ;background-color: #F4F6F6; border:2px;   cellpadding:8px ">
		       
			<tr>
				<th>First Name:</th>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<th>Last Name:</th>
				<td><form:input path="userLastName" />
				
				 </td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><form:input path="email" />
				<font color='red'>
				      <div id="dupEmail"></div>
				 </font>
				 </td>
			</tr>
			<tr>
				<th>Mobile:</th>
				<td><form:input path="userPhonenumber" /></td>
			</tr>
			<tr>
				<th>Date-Of-Birth:</th>
				<td><form:input path="dateOfBirth"/></td>
			</tr>
			<tr>
				<th>Gender:</th>
				<td>Male:<form:radiobutton path="Gender" value="M"
						id="gender" /> Female:<form:radiobutton path="Gender"
						value="F" id="gender" />
				</td>
			</tr>
			<tr>
				<th>Role:</th>
				<td><form:select path="roleId">
						<form:option value="">-Select-</form:option>
						<form:option value="">Case Worker</form:option>
						<form:option value="">Admin</form:option>
					</form:select></td>
			</tr>
			
			<tr>
				<th></th>
				<td><input type="submit" value="Reset">&nbsp;<input
					type="submit" value="Create"></td>
			</tr>
		</table>
		</div>
	</form:form>
</body>
</html>