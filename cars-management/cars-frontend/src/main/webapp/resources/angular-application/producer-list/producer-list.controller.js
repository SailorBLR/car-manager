/**
 * Created by Anton Hubarevich on 24.04.2017.
 */
'use strict';

/**car source select controller. Makes request to API. GET list of sources*/
angular.module('producerList').component('producerList', {
    templateUrl: 'resources/angular-application/producer-list/producer-list.template.html',
    controller: ['$http', '$scope', 'localStorageService', 'SetProducer',
        function ProducerListController($http, $scope, localStorageService, SetProducer) {
            var baseUrl = "http://localhost:8080/";
            var vm = this;

            $http
                .get(baseUrl + "/producers")
                .then(function (data) {
                        $scope.producers = data.data;
                        $scope.currentProducer = $scope.producers[0];

                        if (localStorageService.get('currProducer') === null) {
                            localStorageService.set('currProducer', $scope.currentProducer);
                        } else {
                            var temp = localStorageService.get('currProducer');
                            $scope.currentProducer = temp;
                        }
                    }
                );

            $scope.buildModel = function () {
               return $http
                    .get(baseUrl + "models/producerId/" + $scope.currentProducer.producerProxyId)
                    .then(function (data) {
                            $scope.models = data.data;
                            if ($scope.models.length > 0) {
                                $scope.currentModel = $scope.models[0];

                                if (localStorageService.get('currModel') === null) {
                                    localStorageService.set('currModel', $scope.currentModel);
                                    //Else get from session
                                } else {
                                    var temp = localStorageService.get('currModel');
                                    $scope.currentModel = temp;
                                }
                            }
                        }
                    );
            };

            //Watching for the local storage changes

            $scope.$watch('currentProducer', function (newValue, oldValue) {
                if (newValue !== oldValue && newValue !== undefined) {
                    localStorageService.set('currProducer', newValue);
                    localStorageService.set('currModel', null);
                    $scope.buildModel();
                }
                SetProducer.setProducer(localStorageService.get('currProducer'));
            });

            $scope.$watch('currentModel', function (newValue, oldValue) {
                if (newValue !== oldValue && newValue !== undefined) {
                    localStorageService.set('currModel', newValue);
                }
                SetProducer.setModel(localStorageService.get('currModel'));
            });


        }
    ]
});