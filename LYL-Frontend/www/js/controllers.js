angular.module('starter.controllers', [])

.controller('ChatsCtrl', function($scope, Chats) {
  // With the new view caching in Ionic, Controllers are only called
  // when they are recreated or on app start, instead of every page change.
  // To listen for when this page is active (for example, to refresh data),
  // listen for the $ionicView.enter event:
  //
  //$scope.$on('$ionicView.enter', function(e) {
  //});

  $scope.chats = Chats.all();
  $scope.remove = function(chat) {
    Chats.remove(chat);
  };
})

.controller('ChatDetailCtrl', function($scope, $stateParams, Chats) {
  $scope.chat = Chats.get($stateParams.chatId);
})

.controller('AccountCtrl', function($scope) {
  $scope.settings = {
    enableFriends: true
  };
})

.controller('CustomerCtrl', function($scope, $http) {
  $scope.load = function(){
    $http.get('http://localhost:8080/user/getUserById?id=1').
    then(function(response) {
            $scope.user = response.data;
        },
        function(errResponse) {
            $scope.error = errResponse.status + " - " + errResponse.statusText;
        });
  }

  $scope.getDaysToEvent = function(date){
    var startDate = new Date(date);  // 2000-01-01
    var endDate =   new Date();              // Today

    var ndays;
    var tv1 = endDate.valueOf();  // msec since 1970
    var tv2 = startDate.valueOf();

    ndays = (tv2 - tv1) / 1000 / 86400;
    ndays = Math.round(ndays - 0.5);

    return ndays;
  }
})

.controller('BoardDetailCtrl', function($scope, $http, $stateParams) {

    $http.get('http://localhost:8080/luckyBoard/getBoardById?id=' + $stateParams.boardId).
    then(function(response) {
            $scope.board = response.data;
        },
        function(errResponse) {
            $scope.error = errResponse.status + " - " + errResponse.statusText;
        });
});

