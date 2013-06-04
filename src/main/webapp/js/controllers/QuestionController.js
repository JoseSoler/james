'use strict';

meetingMoodApp.controller('QuestionController',
function QuestionController($scope, $location, $http, $templateCache) {

    $scope.yourName = "Anonymous_" + randomStr (5);
    $scope.location = $location;

    $scope.submitanswer = function() {
	
	        $http({method: 'GET', url: 'http://l-lab-01.zanox-live.de:8080/james/rest/getQuestion?qId=' + $scope.questionId, cache: $templateCache}).
            success(function(data, status, headers, config) {
			
				$http({method: 'GET', url: 'http://l-lab-01.zanox-live.de:8080/james/rest/setAnswer?qId=1&answer=' + $scope.answer, cache: $templateCache}).
				success(function(data, status, headers, config) {
					$location.path('/questionsuccess'); 
				}).
				error(function(data, status, headers, config) {
					$scope.apps = data || "Request failed";
					$scope.status = status;
					templateUrl: 'views/questionconnection.html'
				});
				
                
            }).
            error(function(data, status, headers, config) {
                $scope.apps = data || "Request failed";
                $scope.status = status;
                templateUrl: 'views/questionconnection.html'
            });	
    }	
	
});
