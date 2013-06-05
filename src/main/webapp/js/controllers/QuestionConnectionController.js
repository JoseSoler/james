'use strict';

JamesApp.controller('QuestionConnectionController',
function QuestionConnectionController($scope, $location, $http, $templateCache, $rootScope) {

    $scope.submitquestion = function() {
	        $http({method: 'GET', url: 'http://l-lab-01.zanox-live.de:8080/james/rest/getQuestion?qId=' + $scope.questionId, cache: $templateCache}).
            success(function(data, status, headers, config) {
			
				// Persist the question id
				setCookie("currentQuestion",$scope.questionId,30);
				$rootScope.sharedVars.qId = $scope.questionId;
				
				$location.path('/question'); 
            }).
            error(function(data, status, headers, config) {
				$rootScope.sharedVars.messages = "Request failed";
				$scope.status = status;
            });	
    }
	
});
