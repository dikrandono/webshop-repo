
	var app = angular.module('myApp', [ 'ngCookies', 'ngRoute' ]);
	
	app.config(function($routeProvider) {
	
		$routeProvider.when("/", {
			templateUrl : "/webshop/resources/angularPages/NewFile.html"
		}).when("/index", {
			templateUrl : "/webshop/resources/angularPages/homeAng.html"
		}).when("/personsAng", {
			templateUrl : "/webshop/resources/angularPages/personsAng.html"
			//controller : 'PersonsCtrl'
		}).otherwise({
			redirectTo : '/'
		});
	});

	app.controller('PersonsCtrl', [ '$scope', '$http', '$httpParamSerializer','$cookies', '$location',
			                function($scope, $http, $httpParamSerializer, $cookies, $location) {
	
				$scope.personsList = [];
				$scope.personForm = { 
				                      id : -1,
						              firstname: "",
									  lastname : "",
									  username : "",
									  password : "" 
									};
	          
				_refreshPersonsData();

				$scope.submitPerson = function() {
	
						var method = "";
						var url = "";
						if ($scope.personForm.id == -1) {
							// Id is absent in form data, it is create new person operation
							method = "POST";
							url = '/webshop/data/PersonAddAng';
						} else {
							// Id is present in form data, it is edit person operation
							method = "POST";
							url = '/webshop/data/PersonEditAng';
						}
						 
						
						$http({
							method : method,
							url : url,
							headers : {"Authorization" : "Bearer " + $cookies.get('access_token')},
							data : angular.toJson($scope.personForm)
		        			//headers : {'Content-Type' : 'application/json'}
						   }).then(_success, _error);
				        };
	
				// HTTP DELETE- delete person by Id
				$scope.deletePerson = function(person) {
					 
					$http({
						method : 'POST',
						url : '/webshop/data/PersonDeleteAng/' + person.id,
						headers : {"Authorization" : "Bearer " + $cookies.get('access_token')}
					}).then(_success, _error);
				};
	
				// In case of edit, populate form fields and assign form.id with
				// person id
				$scope.editPerson = function(person) {
	
					$scope.personForm.firstname = person.firstname;
					$scope.personForm.lastname = person.lastname;
					$scope.personForm.username = person.username;
					$scope.personForm.password = person.password;
					$scope.personForm.id = person.id;
				};
	
				
				 /* Private Methods */
				// HTTP GET- get all persons collection
				function _refreshPersonsData() {
					$http({
						method : 'GET',
						url : 'http://localhost:8080/webshop/data/PersonAng',
						headers : {"Authorization" : "Bearer " + $cookies.get('access_token')}
					}).then(function successCallback(response) {
						 //alert(response.data);
						 $scope.personsList = response.data;
					}, function errorCallback(response) {
						alert("ERRORRRR   " + response.data  );
						console.log(response.statusText);
					});
				}
				
	
				function _success(response) {
					_refreshPersonsData();
					_clearFormData()
				}
	
				function _error(response) {
					console.log(response.data);
				}
	
				// Clear the form
				function _clearFormData() {
	
					$scope.personForm.firstname = "";
					$scope.personForm.lastname =  "";
					$scope.personForm.username =  "";
					$scope.personForm.password =  "";
					$scope.personForm.id = -1;
	
				};
	
			} ]);
	


 app.controller( 'mainCtrl',
				      [ '$scope',
						'$http',
						'$httpParamSerializer',
						'$cookies',
						'$location',
						function($scope, $http, $httpParamSerializer, $cookies,
								$location) {

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
									}, data : $httpParamSerializer($scope.data)

								}

								$http(req).success( function(data) {

										// alert('data.data.access_token= ' + data.access_token);
										$http.defaults.headers.common.Authorization = 'Bearer ' + data.access_token;

										$cookies.put("access_token", data.access_token);
											 
										// window.location.href = "index";
										$location.path('/index');

								}).error(
									function(data, status) {
										alert("Error: Invalid username or password ");
								});
							}
						}]);
