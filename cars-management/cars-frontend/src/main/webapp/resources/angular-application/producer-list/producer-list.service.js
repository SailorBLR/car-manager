/**
 * Created by Anton Hubarevich on 24.04.2017.
 */
'use strict';
/**Performs data transfer between modules*/
angular.
module('producerList').
factory('SetProducer', function () {

    var producer = ' ';
    var model = ' ';

    return {
        getProducer: function () {
            return producer;
        },
        setProducer: function (prod) {
            producer = prod;
        },

        getModel:  function () {
            return model;
        },

        setModel: function (mod) {
            model = mod;
        }
    };
});