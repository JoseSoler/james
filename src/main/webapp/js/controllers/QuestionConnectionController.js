'use strict';

meetingMoodApp.controller('QuestionConnectionController',
function QuestionConnectionController($scope, $location, $http, $templateCache) {

    $scope.submitquestion = function() {
	        $http({method: 'GET', url: 'http://l-lab-01.zanox-live.de:8080/james/rest/getQuestion?qId=' + $scope.questionId, cache: $templateCache}).
            success(function(data, status, headers, config) {
				setCookie("currentQuestion",$scope.questionId,30);
				$location.path('/question'); 
            }).
            error(function(data, status, headers, config) {
                $scope.apps = data || "Request failed";
                $scope.status = status;
                templateUrl: 'views/questionconnection.html'
            });	
    }
	
});
