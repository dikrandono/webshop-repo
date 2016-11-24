<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
<link href="<c:url value="/resources/css/mystyle.css" />" rel="stylesheet">

<title>${message}</title>
</head>
<body>


	<h2>${message}</h2>


	<table>
		<tr>
			<td style="background-color: silver;">Titel</td>
			<td style="background-color: silver;">Auther</td>
		</tr>
		<c:forEach var="book" items="${books}">
			<tr>
				<td>${book.titel}</td>
				<td>${book.auther}</td>

				<td>  
				      <a class="blue-button" href="/webshop/bookform/${book.id}">Edit</a>
					| <a class="red-button" href="/webshop/deletebook/${book.id}">Delete</a>
				</td>

			</tr>
		</c:forEach>
	</table>

	<table>
	
		<tr>
			<td><a class="blue-button" href="/webshop/bookformadd">Add Book</a></td>
		</tr>

	</table>


</body>
</html>