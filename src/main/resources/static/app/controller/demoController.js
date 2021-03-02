'use strict';

angular.module("demoApp")
    .controller('demoCtrl', ['$http', 'DemoService', 'NgTableDemoService', function ($http, DemoService, NgTableDemoService) {
        var self = this;

        self.buttonMessage = "Get";
        self.tooltip = 'Call back-end';

        self.get = function () {
            DemoService.getDemo().then(
                function (response) {
                    self.response = response;
                }
            );
        };

        self.submit = function (checkboxModel) {
            console.log("checkboxModel is", checkboxModel);
            console.log(self.customersSelected);
        };

        NgTableDemoService.getAll().then(
            function (response) {
                self.customers = response;
            });
    }]);