'use strict';

meetingMoodApp.controller('QuestionController',
function QuestionController($scope, $location, $templateCache) {

    $scope.yourName = "Anonymous_" + randomStr (5);
    $scope.location = $location;

    $scope.submitanswer = function() {
	
	        $http({method: 'GET', url: 'http://l-lab-01.zanox-live.de:8080/james/rest/getQuestion?qId=' + $scope.questionId, cache: $templateCache}).
            success(function(data, status, headers, config) {
			
				$http({method: 'SET', url: 'http://l-lab-01.zanox-live.de:8080/james/rest/setAnswer?qId=1&answer=' + $scope.answer, cache: $templateCache}).
				success(function(data, status, headers, config) {
					$location.path('/questionsuccess.html'); 
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
		
		Restangular.getQuestion('projects', $route.current.params.projectId).get();
		
		$location.path('/meeting'); 
    }
	
	$scope.people = Restangular.all('person').getList();
	
	$scope.meetingId = $location.search()['meetingId'];
	
});

ConnectionController.$inject = ['$scope', '$http', '$templateCache'];

http://l-lab-01.zanox-live.de:8080/james/rest/setAnswer?qId=1&answer=nothing"
http://l-lab-01.zanox-live.de:8080/james/rest/getQuestion?id=1
