{
	app.controller('listTodos', ($scope, $http) => {
    $http.get('listTodos').
        then(function(response) {
            $scope.todos = response.data;
        });
});
}