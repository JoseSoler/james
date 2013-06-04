'use strict';

meetingMoodApp.controller('ConnectionController',
function ConnectionController($scope, $location) {

    $scope.yourName = "Anonymous_" + randomStr (5);
    $scope.location = $location;

    $scope.connect = function() {
		setCookie("meetingId",$scope.meetingId,30);
		setCookie("yourName",$scope.yourName,30);
		setCookie("currentMood","grey",30);
		setCookie("currentNeed","noneed",30);
		
		$location.path('/meeting'); 
    }
	
	$scope.meetingId = $location.search()['meetingId'];
	
});
