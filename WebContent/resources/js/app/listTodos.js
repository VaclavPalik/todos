{
	app.controller('listTodos', ($rootScope, $scope, $http) => {
		$scope.loadData = () => {$http.get('listTodos').
			then((response) => {
				$scope.todos = response.data;
			});
		}
		$scope.passData = (todo) =>{
			$rootScope.$broadcast('passTodo', jQuery.extend(true, {}, todo));
		};
		$scope.loadData();
		$scope.$on('refresh', (event) =>{
			$scope.loadData();
		});
});
}