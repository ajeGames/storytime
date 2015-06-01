(function() {
    'use strict';

    angular
        .module('scratchApp', []);

    angular
        .module('scratchApp')
        .factory('dataservice', dataservice);

    dataservice.$inject = ['$http'];

    function dataservice($http) {
        return {
            getAvengers: getAvengers
        };

        function getAvengers() {
            return $http.get('/api/storytime')
                .then(getAvengersComplete)
                .catch(getAvengersFailed);

            function getAvengersComplete(response) {
                return response.data;
            }

            function getAvengersFailed(error) {
                alert('fail');
            }
        }
    }

    angular
        .module('scratchApp')
        .controller('ScratchCtrl', ScratchCtrl);

    ScratchCtrl.$inject = ['$scope', 'dataservice'];

    function ScratchCtrl($scope, dataservice) {
        $scope.message = "Initializing...";
        $scope.result = {};

        activate();

        function activate() {
            $scope.message = "Activating";
            return getAvengers().then(function() {
                $scope.message = "Activated";
            });
        }

        function getAvengers() {
            return dataservice.getAvengers()
                .then(function(data) {
                    $scope.result = data;
                });
        }
    }
})();
