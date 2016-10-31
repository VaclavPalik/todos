{
	app.controller("createTodo",  ($rootScope, $scope, $http, $filter) => {
		$scope.sendForm = (event) => {
			event.preventDefault();
			$http({
				method: 'POST',
				url: 'createTodo', 
				data: $.param({
					'description': $scope.description, 
					'resolveUntil': $scope.resolveUntil
						}),
				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
				}).success((data) => {
					$scope.todo=data;
					UIkit.modal("#createNew").hide();
					$rootScope.$broadcast('refresh');
					UIkit.modal.alert('Created new Todo: '+$scope.todo.description+" with deadline: "+$filter('date')($scope.todo.resolveUntil,'dd.MM.yyyy'));
			});
		};
	});
}