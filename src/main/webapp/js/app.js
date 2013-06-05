'use strict';

var JamesApp = angular.module('JamesApp', ['ngResource', 'JamesAppServices']);

JamesApp.run(function ($rootScope) {
    $rootScope.sharedVars = {
        qId : ""
    }
});

JamesApp.config(function($routeProvider) {

  $routeProvider.
      when('/', {
        controller: 'ConnectionController',
        templateUrl: 'views/connection.html'
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
      when('/question', {
        controller: 'QuestionController',
        templateUrl: 'views/question.html'
      }).
      when('/questionsuccess', {
        templateUrl: 'views/questionsuccess.html'
      });
	
});