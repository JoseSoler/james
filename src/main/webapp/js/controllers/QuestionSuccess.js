'use strict';

JamesApp.controller('QuestionSuccessController',
function QuestionSuccessController($scope, $location, $http, $templateCache, $rootScope) {
	
	$scope.back = function() {
		$location.path('/aspen'); 
	}
	
});
