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
<link href="<c:url value="/resources/css/mystyle.css" />" rel="stylesheet">

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