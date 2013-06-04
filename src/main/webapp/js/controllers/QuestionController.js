'use strict';

meetingMoodApp.controller('QuestionController',
function QuestionController($scope, $location, $http, $templateCache) {

	/* ----------- Initialize the question ----------- */
	$scope.questionId = getCookie("currentQuestion");
	
	$http({method: 'GET', url: 'http://l-lab-01.zanox-live.de:8080/james/rest/getQuestion?qId=' + $scope.questionId, cache: $templateCache}).
	success(function(data, status, headers, config) {
		$scope.questionText = data;
	}).
	error(function(data, status, headers, config) {
		$scope.apps = data || "Request failed";
		$scope.status = status;
		templateUrl: 'views/questionconnection.html';
	});	
	/* ------------------------------------------------ */
	
    $scope.submitanswer = function() {
	
	        $http({method: 'GET', url: 'http://l-lab-01.zanox-live.de:8080/james/rest/setAnswer?qId=' + $scope.questionId + '&answer=' + $scope.answer, cache: $templateCache}).
            success(function(data, status, headers, config) {
				$location.path('/questionsuccess'); 
            }).
            error(function(data, status, headers, config) {
                $scope.apps = data || "Request failed";
                $scope.status = status;
                templateUrl: 'views/questionconnection.html'
            });	
    }
	
});
