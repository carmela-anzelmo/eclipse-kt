'use strict';

var demoApp = angular.module('demoApp', ['ngRoute', 'ui.bootstrap', 'ngTable']);

demoApp.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'views/main.html'
        })
        .when('/form', {
            templateUrl: 'views/demo.html',
            controller: 'demoCtrl',
            controllerAs: 'demoController'
        })
        .when('/ngTable', {
            templateUrl: 'views/ngTable-demo.html',
            controller: 'ngTableDemoCtrl',
            controllerAs: 'ngTableDemoController'
        });
});