'use strict';

JamesApp.controller('QuestionSuccessController',
function QuestionSuccessController($scope, $location, $http, $templateCache, $rootScope) {
	
	$scope.successback = function() {
		$location.path('/question'); 
	}
	
});
