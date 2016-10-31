{
	app.controller('listTodos', ($scope, $http) => {
		$scope.loadData = () => {$http.get('listTodos').
			then((response) => {
				$scope.todos = response.data;
			});
		}
		$scope.loadData();
		$scope.$on('refresh', (event) =>{
			$scope.loadData();
		});
});
}