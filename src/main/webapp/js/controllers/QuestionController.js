'use strict';

JamesApp.controller('QuestionController',
function QuestionController($scope, $location, $http, $templateCache, $rootScope) {
	$scope.button=false;
	
	/* ----------- Initialize the question ----------- */
	if ($rootScope.sharedVars.qId == "")
		$scope.questionId = getCookie("currentQuestion");
	else
		$scope.questionId = $rootScope.sharedVars.qId;
	
	$http({method: 'GET', url: 'http://labs.zanox.com:8080/james/rest/getQuestion?id=' + $scope.questionId, cache: $templateCache}).
	success(function(data, status, headers, config) {
		if (data.result == "success")
		{
			$scope.questionText = data.question;
		}
		else
		{
			rootScope.sharedVars.messages = data.message;
			$location.path('/aspen'); 
		}
	}).
	error(function(data, status, headers, config) {
		$rootScope.sharedVars.messages = "Request failed";
		$scope.status = status;
	});	
	/* ------------------------------------------------ */
	
    $scope.submitanswer = function() {
			$scope.button=true;
	
	        $http({method: 'GET', url: 'http://labs.zanox.com:8080/james/rest/setAnswer?id=' + $scope.questionId + '&answer=' + $scope.answer, cache: $templateCache}).
            success(function(data, status, headers, config) {
				if (data.result == "success")
				{
					$rootScope.sharedVars.messages = "";
					$location.path('/questionsuccess');
				}
				else
				{
					$rootScope.sharedVars.messages = data.message;
				}
            }).
            error(function(data, status, headers, config) {
                $rootScope.sharedVars.messages = "Request failed";
                $scope.status = status;
            });	
    }
	
});
