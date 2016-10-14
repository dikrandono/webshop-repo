<#import "spring.ftl" as spring />
<html>
<head>

<link rel="stylesheet" type="text/css"  href="<@spring.url '/resources/css/mystyle.css'/>"/>
<title>FreeMarker Persons Page</title>
</head>

<body>

<h2>${message}</h2>


<div id="content">
    
    <fieldset>
    	<legend>Add/Edit Person</legend>
  	
		  <form name="person" action="/webshop/savePerson/" method="post">
		  
		  <table >
		  <tr><td>
		  	Firstname:
		  		</td>
		  	<td> <input type="text" name="firstname" value="${person.firstname}"/>	<br/>
		  	</td></tr>
		  	<tr><td>
		  	Lastname:
		  	</td><td> <input type="text" name="lastname" value="${person.lastname}"/>	<br/>
		  	</td></tr>
		  	<tr><td>
		  	Username: </td><td><input type="text" name="username" value="${person.username}"/>	<br/>
		  	</td></tr>
		  	<tr><td>
		  	Password: </td><td><input type="password" name="password" value="${person.password}" />	<br/>
		  	</td></tr>
		  	
		  	</table>
		  	<input type="hidden" name="id" value="${person.id}" />
		  	<input type="submit" value="   Save   "  class="blue-button"/>
		  </form>
	  
	  </fieldset>
  <br/>
  
  
  <table class="datatable">
  	<tr>
  		<th>Firstname</th>  <th>Lastname</th>
  	</tr>
    
  	<#list personsList as per>
      <tr>
        <td>${per.firstname}</td> 
        <td>${per.lastname}</td>
        <td><a class="blue-button" href="/webshop/editperson/${per.id}">Edit</a>
		  | <a class="red-button" href="/webshop/deleteperson/${per.id}">Delete</a></td>
      </tr>
    </#list>
   
  </table>
  
  </div>
 

</body>

</html>
