'use strict';

JamesApp.controller('QuestionController',
function QuestionController($scope, $location, $http, $templateCache, $rootScope, $routeParams) {
	$scope.button=false;
	
	/* ----------- Initialize the question ----------- */
	if ($routeParams.questionId != "" && $routeParams.questionId != null)
	{
		sessionStorage.questionId = $routeParams.questionId;
		sessionStorage.showBackButton = false;
		$scope.questionId = sessionStorage.questionId;

		$rootScope.sharedVars.qId = $scope.questionId;
		$rootScope.sharedVars.messages = "";

		$scope.showBackButton = false;
	}
	else
	{
		$scope.showBackButton = true;
		if ($rootScope.sharedVars.qId == "")
			$scope.questionId = sessionStorage.questionId;
		else
			$scope.questionId = $rootScope.sharedVars.qId;
	}
	
	/* --------- Display "back" button  --------- */
	if (sessionStorage.showBackButton == null) sessionStorage.showBackButton = true;
	
	$scope.showBackButton = sessionStorage.showBackButton;
	
	/* ---------- Get the question text ---------- */
	$http({method: 'GET', url: encodeURI(sessionStorage.restURL + 'getQuestion?id=' + $scope.questionId), cache: $templateCache}).
	success(function(data, status, headers, config) {
		if (data.result == "success")
		{
			$scope.questionText = data.question;
		}
		else
		{
			$rootScope.sharedVars.messages = data.message;
			$location.path('/aspen'); 
		}
	}).
	error(function(data, status, headers, config) {
		$rootScope.sharedVars.messages = "Request failed";
		$scope.status = status;
	});	
	/* ------------------------------------------------ */
	
	$scope.back = function() {
		$location.path('/aspen'); 
	}
	
    $scope.submitanswer = function() {
			$scope.button=true;
	
	        $http({method: 'GET', url: encodeURI(sessionStorage.restURL + 'setAnswer?id=' + $scope.questionId + '&answer=' + $scope.answer), cache: $templateCache}).
            success(function(data, status, headers, config) {
				if (data.result == "success")
				{
					$rootScope.sharedVars.messages = "";
					$location.path('/questionsuccess');
				}
				else
				{
					$scope.button=false;
					$rootScope.sharedVars.messages = data.message;
				}
            }).
            error(function(data, status, headers, config) {
                $rootScope.sharedVars.messages = "Request failed";
                $scope.status = status;
				$scope.button=false;
            });	
    }
	
});
