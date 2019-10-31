<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" dir="ltr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" >
<title>Get User</title>
<link rel="stylesheet" href="LoanClientSide/src/main/webapp/WEB-INF/views/login.css"> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>
<script>
function js(){
	
	if(document.getElementById("user").value == ""){
		alert("user Name is Required");
	} else {
		document.getElementById("myForm").submit();
	}
}
</script>
</head>
<body>
   <div align="center">
   <table>
        <form:form action="userlist" method="post" modelAttribute="user" id="myForm">
    		<h1>Enter UserName</h1>
    			<tr><td>User Name:</td>
               	<td><form:input path="userName" id="user"/></td></tr>
               	<tr> <td colspan="2" align="center"> <input type="button" value="show" onclick="js()"> </td></tr>
        </form:form>
	</table>
	</div>
</body>
</html>