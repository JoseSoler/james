'use strict';

meetingMoodApp.controller('MeetingController',
function MeetingController($scope, $location, MeetingManager) {

	$scope.meetingMood = generateImgUrl("","","","grey");
	$scope.meetingMoodForecast = generateImgUrl("","","neutral","");
	$scope.comments = [];
	
	$scope.meetingId = getCookie("meetingId");
	$scope.yourName = getCookie("yourName");
	$scope.currentMood = generateImgUrl(getCookie("currentMood"),"","","");
	$scope.currentNeed = generateImgUrl("",getCookie("currentNeed"),"","");
		 
	MeetingManager.init();
	
	$scope.load = function() {
		MeetingManager.connect($scope.meetingId, $scope.yourName);
		//MeetingManager.updateMood($scope.currentMood);
		//MeetingManager.updateNeed($scope.currentNeed);
	}
	
	$scope.addComment = function() {

		$scope.comments.push({"text": $scope.commentText,
		 "author": $scope.yourName,
		 "datetime_": printDate()});	
	
		//MeetingManager.addComment($scope.commentText, $scope.yourName);
		$scope.commentText = "";
	}

	$scope.changeMood = function() {
		$location.path('/mood'); 
	}
	
	$scope.refreshHack = function(meetingMood, meetingMoodForcast) {
		$scope.meetingMood = generateImgUrl("","","", meetingMood);
		$scope.meetingMoodForecast = generateImgUrl("","",meetingMoodForcast,"");
	}
	
	setInterval(function(){
        $scope.$apply(function() {
		
			var statusArray = ['green', 'yellow', 'red'];  
			var randStatus = statusArray[Math.floor(Math.random() * statusArray.length)];
			
			var forecastArray = ['down', 'neutral', 'up'];  
			var randForecast = forecastArray[Math.floor(Math.random() * forecastArray.length)];
			
            $scope.refreshHack(randStatus,randForecast);
			
			var messageArray = [
			{"text": "servus!", "author": "Christian", "datetime_": printDate()},
			{"text": "gretings!", "author": "Anonymous_xxx", "datetime_": printDate()},
			{"text": "This meeting is awesome!", "author": "TBI", "datetime_": printDate()},
			{"text": "brauch Kaffee!!", "author": "Daniela", "datetime_": printDate()},
			{"text": "wann gipts mittagessen!", "author": "Mike", "datetime_": printDate()},
			{"text": "James rules!!", "author": "Dragan", "datetime_": printDate()},
			{"text": "huhu, I´m here as well!", "author": "Thomas", "datetime_": printDate()},
			{"text": "hjfgj!", "author": "lllakakalakalka", "datetime_": printDate()},
			{"text": "Freibier für alle!!", "author": "Thomas Koch", "datetime_": printDate()},
			{"text": "Winner!", "author": "Chris L.", "datetime_": printDate()},
			{"text": "eindeutig die coolste App!", "author": "Christian", "datetime_": printDate()},
			{"text": "rockt volle Kanne!", "author": "Chris", "datetime_": printDate()},
			{"text": "geil!", "author": "asdfsadfdsaf", "datetime_": printDate()},
			{"text": "whehewwwwwwwwwwwww!", "author": "Dennis", "datetime_": printDate()},
			{"text": "jippie!", "author": "Christian", "datetime_": printDate()},
			{"text": "grätings!", "author": "Anonymous_xxx","datetime_": printDate()}
			];  
			var randMessage = messageArray[Math.floor(Math.random() * messageArray.length)];
			$scope.comments.push(randMessage);
			 
			//$scope.load();
        });
    }, 5000);
	
	MeetingManager.refresh = function(context) {
		$scope.comments = context.comments;
		$scope.meetingMood = generateImgUrl("","","", context.meetingMood);
		$scope.meetingMoodForecast = generateImgUrl("","",context.meetingMoodForcast,"");
		//$scope.$digest();
	}
	
});
