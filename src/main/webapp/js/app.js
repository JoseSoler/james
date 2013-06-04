'use strict';

var meetingMoodApp = angular.module('meetingMoodApp', ['ngResource', 'meetingMoodAppServices']);

meetingMoodApp.config(function($routeProvider) {

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
      });
});
