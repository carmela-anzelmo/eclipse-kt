'use strict';

var demoApp = angular.module('demoApp', ['ngRoute']);

demoApp.config(function ($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl: "views/demo.html",
            controller: "demoCtrl",
            controllerAs: "demoController"
        })
});