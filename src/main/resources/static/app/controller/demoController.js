'use strict';

angular.module("demoApp")
    .controller('demoCtrl', ['$http', 'DemoService', function ($http, DemoService) {
        var self = this;

        self.get = function () {
            DemoService.getDemo().then(
                function (response) {
                    self.response = response;
                }
            );
        };
    }]);