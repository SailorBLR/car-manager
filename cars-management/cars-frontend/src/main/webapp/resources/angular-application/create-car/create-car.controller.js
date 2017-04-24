/**
 * Created by Anton Hubarevich on 24.04.2017.
 */
'use strict';

/**Create news controller*/
angular.
module('createCar').
component('createCar',  {
    templateUrl: 'resources/angular-application/create-car/create-car.template.html',
    controller: ['$scope', '$http', 'localStorageService',
        function CreateNewsController($scope, $http, localStorageService) {

            $scope.defaultValues = {produceYear: null, fuel: "gas", transmission: "automatic"};

            //Resets the values in a form
            $scope.reset = function() {
                $scope.car = angular.copy($scope.defaultValues);
            };

            //Creates new item
            $scope.save = function() {
                $scope.objectToSend = angular.copy($scope.car);
                $scope.objectToSend['producerProxyId'] = localStorageService.get("currProducer").producerProxyId;
                $scope.objectToSend['modelProxyId'] = localStorageService.get("currModel").carModelProxyId;

                $http({
                    method: 'POST',
                    url: 'create/insert',
                    data: {
                        "producerId": $scope.objectToSend.producerProxyId,
                        "modelId": $scope.objectToSend.modelProxyId,
                        "produceYear": $scope.objectToSend.produceYear.getTime(),
                        "fuel": $scope.objectToSend.fuel,
                        "transmission": $scope.objectToSend.transmission

                    },
                    headers: {'Content-Type': 'application/json'}
                });
                window.location.href = "#/";
            };
        }
    ]
});