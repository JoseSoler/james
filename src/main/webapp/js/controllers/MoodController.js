'use strict';

JamesApp.controller('MoodController',
function MoodController($scope, $location) {

    $scope.changeMood = function(mood) {
		setCookie("currentMood",mood, 30);
		
		$location.path('/meeting');  
    }
	
	$scope.changeNeed = function(need) {
		var oldNeed = getCookie("currentNeed");
		
		if (oldNeed == need)
			setCookie("currentNeed","noneed",30);
		else
			setCookie("currentNeed",need,30);
		
		$location.path('/meeting');  
    }
	
});