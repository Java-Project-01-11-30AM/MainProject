<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

<script>
   $(document).ready(function(){
	   $('#contactTbl').DataTable({
		   "pagingType": "full_numbers"
	   });
   });
function deleteConfirm(){
	return confirm("Are you sure,you want to delete?")
}
</script>
</head>
<body>
	<h3>View Accounts </h3>
	
	<a href="userAccReg">  + Add New Contact"
</a>
<table border="1"  id ="contactTbl">
	<thead>
		<tr>
			<th>S.No</th>
			<th>Name</th>
			<th>Email</th>
			<th>Role</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${contacts}" var="c" varStatus="index">
			<tr>
				<td>${index.count+1}</td>
				<td>${c.contactName}</td>
				<td>${c.contactEmail}</td>
				<td>${c.contactNumber}</td>

				<td><a href="editContact?cid=${c.contactId }">Edit</a> 
				    <c:if test="accnt.deleteSw eq Y">
				      <a href="activateAccnt">Activate</a>
				      </c:if>
				      <c:if test = "${c.deletedSwitch =='N'}">
				    <a href="deleteContact?cid=${c.contactId}" onclick="return deleteConfirm()">Delete</a>
				    </c:if>
				</td>
			</tr>
		</c:forEach>

	</tbody>
</table>
</body>
</html>