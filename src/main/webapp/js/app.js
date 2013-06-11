'use strict';

/* -------- GLOBAL SETTING -------- */

sessionStorage.restURL = "http://labs.zanox.com:8080/james/rest/";

/* -------------------------------- */

var JamesApp = angular.module('JamesApp', ['ngResource', 'JamesAppServices']);

JamesApp.run(function ($rootScope) {
    $rootScope.sharedVars = {
        qId : "",
		messages : ""
    }
});

JamesApp.config(function($routeProvider) {

  $routeProvider.
      when('/', {
        controller: 'QuestionConnectionController',
        templateUrl: 'views/questionconnection.html'
      }).
      when('/meeting', {
        controller: 'MeetingController',
        templateUrl: 'views/meeting.html'
      }).
      when('/mood', {
        controller: 'MoodController',
        templateUrl: 'views/mood.html'
      }).
      when('/aspen', {
        controller: 'QuestionConnectionController',
        templateUrl: 'views/questionconnection.html'
      }).
      when('/question/:questionId', {
        controller: 'QuestionController',
        templateUrl: 'views/question.html'
      }).
      when('/question', {
        controller: 'QuestionController',
        templateUrl: 'views/question.html'
      }).
      when('/questionsuccess', {
		controller: 'QuestionSuccessController',
        templateUrl: 'views/questionsuccess.html'
      });
	
});
