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

<title>Languages</title>
</head>
<body>
<h2>${message}</h2>



		  <form method="post" action="/webshop/savelang" >  
		            <table>  
		                 
		                <tr>  
		                    <th colspan="2">Language</th>  
		                 </tr>  
		                <tr>  
		                    <td>Titel</td>  
		                    <td><input type="text" name="titel" value="${lang.titel}"/></td>  
		                </tr>  
		                 
		                <tr>  
		                    <td colspan="2">
		                    <input type="hidden" name="id" value="${lang.id}" />
		                    <input type="submit" value="Save" class="blue-button" />
		                    <a  href="/webshop/langsview" class="blue-button" > Cancel </a>
		                    </td>  
		                </tr>  
		            </table>  
		   </form>  

<table>
		<tr>
			<td style="background-color: silver;">Titel</td>
		</tr>
		<c:forEach var="lang" items="${langs}">
			<tr>
				<td>${lang.titel}</td>

				<td><a class="blue-button" href="/webshop/langform/${lang.id}">Edit</a>
					| <a class="red-button" href="/webshop/deleteLang/${lang.id}">Delete</a></td>

			</tr>
		</c:forEach>
	</table>

	 


</body>
</html>