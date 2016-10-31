{
	app.controller("updateTodo",  ($rootScope, $scope, $http) => {
		$scope.$on('passTodo', (event, todo) =>{
			$scope.todo=todo;
		});
		$scope.sendForm = (event) => {
			event.preventDefault();
			$http({
				method: 'PUT',
				url: 'updateTodo/'+$scope.todo.id, 
				data: {
					'description': $scope.todo.description, 
					'resolveUntil': $scope.todo.resolveUntil,
					'resolved': $scope.todo.resolved
						}
				}).success((data) => {
					UIkit.modal("#edit").hide();
					$rootScope.$broadcast('refresh');
			});
		};
	});
}