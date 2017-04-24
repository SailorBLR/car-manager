/**
 * Created by Anton Hubarevich on 24.04.2017.
 */
'use strict';

/** Registers `carList` component, along with its associated controller and template */
angular.
module('carList').
component('carList', {
    templateUrl: 'resources/angular-application/car-list/car-list.template.html',
    controller: ['$http', '$scope',
        function CarListController($http, $scope) {
            var baseUrl = "http://localhost:8080/";
            var vm = this;
            $http.get(baseUrl + '/cars').
            then(function(data) {
                $scope.cars = data.data;
            });

            $scope.delete = function (carId) {
                $http({
                    method: 'DELETE',
                    url: baseUrl + 'deleteCar/'+ carId
                });
                window.location.href = "/";
            }
        }
    ]
});