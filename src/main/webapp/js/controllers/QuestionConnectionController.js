'use strict';

JamesApp.controller('QuestionConnectionController',
function QuestionConnectionController($scope, $location, $http, $templateCache, $rootScope) {
	$scope.button=false;

    $scope.submitquestion = function() {
			$scope.button=true;

	        $http({method: 'GET', url: encodeURI('http://labs.zanox.com:8080/james/rest/getQuestion?id=' + $scope.questionId), cache: $templateCache}).
            success(function(data, status, headers, config) {
			
				// Persist the question id
				if (data.result == "success")
				{
					setCookie("currentQuestion",$scope.questionId,30);
					$rootScope.sharedVars.qId = $scope.questionId;
					$rootScope.sharedVars.messages = "";
					
					$location.path('/question'); 
				}
				else
				{
					$scope.button=false;
					$rootScope.sharedVars.messages = data.message;
				}
            }).
            error(function(data, status, headers, config) {
				$scope.button=false;
				$rootScope.sharedVars.messages = "Request failed";
				$scope.status = status;
            });	
    }
	
});
