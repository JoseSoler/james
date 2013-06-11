'use strict';

JamesApp.controller('QuestionConnectionController',
function QuestionConnectionController($scope, $location, $http, $templateCache, $rootScope) {
	$scope.button=false;

    $scope.submitquestion = function() {
			$scope.button=true;

	        $http({method: 'GET', url: encodeURI(sessionStorage.restURL + 'getQuestion?id=' + $scope.questionId), cache: $templateCache}).
            success(function(data, status, headers, config) {
			
				// Persist the question id
				if (data.result == "success")
				{
					sessionStorage.questionId = $scope.questionId;
					sessionStorage.showBackButton = true;
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
