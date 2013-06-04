var app = angular.module('angularjs-starter', ['restangular']);
 
app.config(function(RestangularProvider) {
  RestangularProvider.setBaseUrl('http://l-lab-01.zanox-live.de:8080/james/rest');
});
 
// Here it injects Restangular by itself
angular.module('angularjs-starter').controller('NewCtrl', function($scope, Restangular) {
  // My controller
});