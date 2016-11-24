
  
  var app = angular.module('myApp', ['ngCookies', 'ngRoute']);  
  
  app.config(function($routeProvider ) {
	  
	  $routeProvider
	    .when( "/", { templateUrl : "/webshop/angularPages/NewFile.html"} )
	    .when( "/index", { templateUrl : "/webshop/WEB-INF/views/index.jsp"} )
	    .when( "/home", { templateUrl : ""} );
	  });
  
  
     app.controller('mainCtrl',['$scope','$http','$httpParamSerializer','$cookies','$location', 
				function($scope, $http, $httpParamSerializer, $cookies,$location) {

					$scope.data = {
						grant_type : "password",
						username : "",
						password : "",
						client_id : "my-client"
					};
					
					
					$scope.encoded = btoa("my-client:secret");
					
					
					$scope.login = function() {
						
							var req = {
								method : 'POST',
								url : "http://localhost:8080/webshop/oauth/token",
								headers : {
									       "Authorization" : "Basic " + $scope.encoded,
									       "Content-type" : "application/x-www-form-urlencoded; charset=utf-8"
				            } , data : $httpParamSerializer($scope.data)
							
				            }
					 
							
                    	    $http(req).success(function(data) {
                    	    	 
                					//alert('data.data.access_token = ' + data.access_token  );
				                    $http.defaults.headers.common.Authorization = 'Bearer ' + data.access_token;
						            $cookies.put("access_token",data.access_token);
									//window.location.href = "index";
						            $location.path('/index');
						            
                        	}).error(function(data, status) {
                        			alert("ERROR: Invalid username or password "  );
		                    });
					}
				}]);
  
   
  