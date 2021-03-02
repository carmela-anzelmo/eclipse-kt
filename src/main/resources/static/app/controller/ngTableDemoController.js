'use strict';

angular.module("demoApp")
    .controller('ngTableDemoCtrl', ['NgTableParams', 'NgTableDemoService', function (NgTableParams, NgTableDemoService) {
        var self = this;

        self.buttonMessage = "Get";
        self.tooltip = 'Call back-end';

        self.get = function (params) {
            return NgTableDemoService.getPerson(1).then(
                function (response) {
                    return self.response = response;
                }
            );
        };

        self.getAll = function (params) {
            return NgTableDemoService.getAll().then(
                function (response) {
                    return self.response = response;
                }
            );
        };

        self.tableParams = new NgTableParams({}, {
            getData: self.getAll
        });
    }]);