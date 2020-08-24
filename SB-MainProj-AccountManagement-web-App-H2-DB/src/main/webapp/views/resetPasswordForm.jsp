<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Reset Password</title>
    <link rel="stylesheet" href="/css/style.css" >
    <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/js/jquery.validate.min.js"></script>
</head>
<body >
      <h2 align="center">${resetMsg}</h2>
     
    <div align="center">
        <h2>Reset Your Password</h2>
        <p>
        Please enter your login email, and password send to your email:
        </p>
         
        
        <form:form action="forget" modelAttribute="fPwd"
		method="POST">
            <table>
                <tr>
				<td>Your Email :</td>
				<td><form:input path="email" readonly="true" /></td>
			</tr>
			<tr>
				<td>Enter Password :</td>
				<td><form:password path="newPwd" /></td>
			</tr>
			<tr>
				<td>Confirm Password :</td>
				<td><form:password path="confirmPwd" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save"
					onclick="return userLogin" />&nbsp; <input type="reset"
					value="reset" /></td>
			</tr>
            </table>
        </form:form>
    </div>
     
    
     
<script type="text/javascript">
 
    $(document).ready(function() {
        $("#resetPasswordForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                }      
            },
             
            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                }
            }
        });
 
    });
</script>

</body>
</html>