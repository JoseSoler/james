'use strict';

JamesApp.controller('QuestionController',
function QuestionController($scope, $location, $http, $templateCache, $rootScope) {
	$scope.button=false;
	
	/* ----------- Initialize the question ----------- */
	if ($rootScope.sharedVars.qId == "")
		$scope.questionId = getCookie("currentQuestion");
	else
		$scope.questionId = $rootScope.sharedVars.qId;
	
	$http({method: 'GET', url: 'http://labs.zanox.com:8080/james/rest/getQuestion?qId=' + $scope.questionId, cache: $templateCache}).
	success(function(data, status, headers, config) {
		$scope.questionText = data.question;
	}).
	error(function(data, status, headers, config) {
		$rootScope.sharedVars.messages = "Request failed";
		$scope.status = status;
	});	
	/* ------------------------------------------------ */
	
    $scope.submitanswer = function() {
			$scope.button=true;
	
	        $http({method: 'GET', url: 'http://labs.zanox.com:8080/james/rest/setAnswer?qId=' + $scope.questionId + '&answer=' + $scope.answer, cache: $templateCache}).
            success(function(data, status, headers, config) {
				$location.path('/questionsuccess'); 
            }).
            error(function(data, status, headers, config) {
                $rootScope.sharedVars.messages = "Request failed";
                $scope.status = status;
            });	
    }
	
});
