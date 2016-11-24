<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<title>Books</title>

<script type="text/javascript">
	var app = angular.module("BookManagement", []);

	
	app.controller("BookController", function($scope, $http) {

						$scope.books = [];
						$scope.bookForm = {
							id : -1,
							titel : "",
							auther : ""
						};
  
						refreshBookData();
					  
						
						function refreshBookData() {
							$http({
										method : 'GET',
										url : 'http://localhost:8080/webshop/books',
										
									}).then(function successCallback(response) {
								
										$scope.books = response.data;
							}, function errorCallback(response) {
								alert(response.data);
								console.log(response.statusText);
							});
						}
						
						$scope.submitBook = function() {

							var method = "";
							var url = "";
							if ($scope.bookForm.id == -1) {
								
								method = "POST";
								url = '/webshop/addBook';
							} else {
								
								method = "PUT";
								url = '/webshop/updateBook';
							}

							$http({
								method : method,
								url : url,
								data : angular.toJson($scope.bookForm),
								headers : {'Content-Type' : 'application/json'
								}
							}).then(_success, _error);
						};
						
						function _success(response) {
							refreshBookData();
							clearFormData()
						}

						function _error(response) {
							console.log(response.data);
						}

						 
						function clearFormData() {
							$scope.bookForm.id = -1;
							$scope.bookForm.titel = "";
							$scope.bookForm.auther = "";

						};
						
						
						$scope.deleteBook = function(book) {
							$http({method : 'DELETE',
								   url : '/webshop/deleteBook/'+ book.id}).then(_success, _error);
						};

						
						$scope.editBook = function(book) {

							$scope.bookForm.titel = book.titel;
							$scope.bookForm.auther = book.auther;
							$scope.bookForm.id = book.id;
						};
						
 
					});
</script>

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


</head>
<body ng-app="BookManagement" ng-controller="BookController">

         <h1>  
           Books 
         </h1>   

		  <form ng-submit="submitBook()">  
		            <table>  
		                 
		                <tr>  
		                    <th colspan="2">Add/Edit Book</th>  
		                 </tr>  
		                <tr>  
		                    <td>Titel</td>  
		                    <td><input type="text" ng-model="bookForm.titel" /></td>  
		                </tr>  
		                <tr>  
		                    <td>Auther</td>  
		                    <td><input type="text" ng-model="bookForm.auther"  /></td>  
		                </tr>  
		                <tr>  
		                    <td colspan="2"><input type="submit" value="Submit" class="blue-button" /></td>  
		                </tr>  
		            </table>  
		   </form>  

      <table>  
            <tr>  
                
                <th>Book Titel</th>  
                <th>Book Auther</th>  
                <th>Operations</th>  
                 
            </tr>  
   
            <tr ng-repeat="book in books">  
                 
            <td> {{ book.titel }}</td>  
            <td >{{ book.auther }}</td>    
                  
            <td><a ng-click="editBook(book)" class="blue-button">Edit</a> | <a ng-click="deleteBook(book)" class="red-button">Delete</a></td>  
            </tr>  
   
        </table>  


</body>
</html>