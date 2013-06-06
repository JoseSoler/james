'use strict';

JamesApp.controller('QuestionConnectionController',
function QuestionConnectionController($scope, $location, $http, $templateCache, $rootScope) {
	$scope.button=false;

    $scope.submitquestion = function() {
			$scope.button=true;

	        $http({method: 'GET', url: 'http://labs.zanox.com:8080/james/rest/getQuestion?id=' + $scope.questionId, cache: $templateCache}).
            success(function(data, status, headers, config) {
			
				// Persist the question id
				if (data.result == "success")
				{
					setCookie("currentQuestion",$scope.questionId,30);
					$rootScope.sharedVars.qId = $scope.questionId;
					
					$location.path('/question'); 
				}
				else
					rootScope.sharedVars.messages = data.message;
            }).
            error(function(data, status, headers, config) {
				$rootScope.sharedVars.messages = "Request failed";
				$scope.status = status;
            });	
    }
	
});
