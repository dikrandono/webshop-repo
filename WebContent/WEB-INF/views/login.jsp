<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
 
	
</script>

<link href="<c:url value="/resources/css/mystyle.css" />" rel="stylesheet">

</head>
<!--body ng-app="myApp" ng-controller="mainCtrl">

	<div id="login-box"  >

		<h2>Login with Username and Password</h2>

		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value='' ng-model="data.username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' ng-model="data.password" /></td>
			</tr>
			<tr>
				<td colspan='2'><a href="#" ng-click="login()">Login</a></td>
			</tr>
		</table -->


	 <body >
	 <div id="login-box"  >
		<c:if test="${not empty error}">
			<div class="error" > ${error} </div>
		</c:if>
		<form name='loginForm' action="<c:url value='/myLoginform' />" method='POST'>

			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='username' value=''></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="submit" /></td>
				</tr>
			</table>
				
				<input type="hidden"
                       name="${_csrf.parameterName}" value="${_csrf.token}" />
			 
		</form >  


	</div>

</body>
</html>