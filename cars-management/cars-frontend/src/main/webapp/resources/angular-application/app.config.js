/**
 * Created by Anton Hubarevich on 23.04.2017.
 */
'use strict';

angular.
module('carsManagement').
config(['$locationProvider' ,'$routeProvider', 'localStorageServiceProvider',
    function config($locationProvider, $routeProvider, localStorageServiceProvider) {
        $locationProvider.html5Mode({
            enabled:true,
            requireBase: true
        });
        localStorageServiceProvider
            .setPrefix('carsManagement')
            .setStorageType('sessionStorage');
        $routeProvider.
        when('/', {
            template: '<car-list class="view-frame"></car-list>'
        }).
        when('/cars', {
            template: '<car-list class="view-frame"></car-list>'
        }).
        when('/carItem/:carId', {
            template: '<car-item class="view-frame"></car-item>'
        }).
        when('/producers', {
            template: '<producer-list class="view-frame"></producer-list>'
        }).
        when('/create', {
            template: '<create-car class="view-frame"></create-car>'
        }).
        when('/edit', {
            template: '<edit-car class="view-frame"></edit-car>'
        }).
        otherwise({
            template: '<car-list class="view-frame"></car-list>'
        });
    }
]);
