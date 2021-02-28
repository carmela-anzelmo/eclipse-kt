'use strict';

angular.module("demoApp")
    .controller('ngTableDemoCtrl', ['NgTableParams', function (NgTableParams) {
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

        var data = [{ name: "Moroni", age: 50 }];
        self.tableParams = new NgTableParams({}, { dataset: data });
    }]);