<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.blue-button {
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',
		endColorstr='#188BC0', GradientType=0);
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 12px;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #1A87B9
}

.red-button {
	background: #CD5C5C;
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 12px;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #CD5C5C
}

table {
	font-family: "Helvetica Neue", Helvetica, sans-serif;
	width: 50%;
}

caption {
	text-align: left;
	color: silver;
	font-weight: bold;
	text-transform: uppercase;
	padding: 5px;
}

th {
	background: SteelBlue;
	color: white;
}

tbody tr:nth-child(even) {
	background: WhiteSmoke;
}

tbody tr td:nth-child(2) {
	text-align: center;
}

tbody tr td:nth-child(3), tbody tr td:nth-child(4) {
	text-align: center;
	font-family: monospace;
}

tfoot {
	background: SeaGreen;
	color: white;
	text-align: right;
}

tfoot tr th:last-child {
	font-family: monospace;
}

td, th {
	border: 1px solid gray;
	width: 25%;
	text-align: left;
	padding: 5px 10px;
}
</style>

<title>${message}</title>
</head>
<body>

<h2>${message}</h2>
 

		  <form:form method="post" action="/webshop/books/" commandName="book" >  
		            <table>  
		                 
		                <tr>  
		                    <th colspan="2"> Book</th>  
		                 </tr>  
		                <tr>  
		                    <td>Titel</td>  
		                    <td><input type="text" name="titel" value="${book.titel}"/></td>  
		                </tr>  
		                <tr>  
		                    <td>Auther</td>  
		                    <td><input type="text" name="auther" value="${book.auther}" /></td>  
		                </tr>
		                
		                
		                <tr>
		                <td>Languages</td> 
		                  
		                    <td > 
		                     
		                    <form:checkboxes  path="languages" items="${allLangs}" itemLabel="titel" itemValue="titel"/>
		                       
					        <!--     
					        <c:forEach items="${allLangs}" var="lang"  >
							 
							  <form:checkbox path="languages" value="${lang.titel}"  />
							  <c:out value="${lang.titel}"/> 
						 
							</c:forEach>    
					          -->
					          </td>   
		                  </tr>
		                <tr>  
		                    <td colspan="2">
		                    <input type="hidden" name="id" value="${book.id}" />
		                    <input type="submit" value="Save" class="blue-button" />
		                    <a  href="/webshop/booksview" class="blue-button" > Cancel </a>
		                    </td>  
		                </tr>  
		            </table>  
		   </form:form>  


</body>
</html>