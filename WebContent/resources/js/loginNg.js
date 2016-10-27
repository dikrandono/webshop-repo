/**
 * 
 */



var app = angular.module('myApp', []);

  app.controller('mainCtrl',
				function($scope, $http, $httpParamSerializer ) {

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
							}
							,data : $httpParamSerializer($scope.data)
						}
						
						//alert('Sending request' +req.url);
						
						$http(req).success(function(data) {
                        					alert('data.data.access_token = ' + data.access_token  );
						                    $http.defaults.headers.common.Authorization = 'Bearer '
													+ data.access_token;
								            //$cookies.put("access_token",
     						                //	data.data.access_token);
											//window.location.href = "index";
											
										}).error(function(data, status) {
					                       // alert("ERROR: " + data + status);
					                    });
					}
				});
  