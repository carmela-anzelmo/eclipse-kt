'use strict';

angular.module("demoApp")
    .controller('demoCtrl', ['$uibModal', 'DemoService', 'NgTableDemoService', function ($uibModal, DemoService, NgTableDemoService) {
        var self = this;

        self.buttonMessage = "Get";
        self.tooltip = 'Call back-end';
        self.userId = 3;

        self.get = function () {
            DemoService.getDemo().then(
                function (response) {
                    self.response = response;
                }
            );
        };

        self.submit = function (checkboxModel) {
            var modalInstance = $uibModal.open({
                templateUrl: "views/partials/demoModal/viewModal.html",
                controller: "ModalDemoCtrl",
                controllerAs: "modal",
                size: "sm",
                backdrop: "static",
                resolve: {
                    customers: function (NgTableDemoService) {
                        return NgTableDemoService.getAll();
                    },
                    isCheckboxSelected: checkboxModel
                }
            });

            modalInstance.result
                .then(function (data) {
                    self.reason = 'closed';
                    self.date = data;
                    console.info('Modal closed at: ' + data);
                }, function () {
                    self.reason = 'dismissed';
                    console.info('Modal dismissed');
                });
        };

        NgTableDemoService.getAll().then(
            function (response) {
                self.customers = response;
            });
    }]);

angular.module("demoApp")
    .controller("ModalDemoCtrl", ["$uibModalInstance", "customers", "isCheckboxSelected",
        function ($uibModalInstance, customers, isCheckboxSelected) {
            var modal = this;

            if (angular.isDefined(isCheckboxSelected)) {
                modal.isCheckboxSelected = isCheckboxSelected;
            } else {
                modal.isCheckboxSelected = 'undefined';
            }

            modal.customers = customers;

            modal.ok = function () {
                $uibModalInstance.close(new Date());
            };

            modal.cancel = function () {
                $uibModalInstance.dismiss('cancel');
            };
        }]);
