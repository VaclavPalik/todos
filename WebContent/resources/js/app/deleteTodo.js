{
	app.controller("deleteTodo",  ($rootScope, $scope, $http) => {
		$scope.executeDelete = (id) => {
			UIkit.modal.confirm("Are you sure?", ()=>{
				$http({
					method: 'DELETE',
					url: 'deleteTodo/'+id, 
					}).success((data) => {
						$rootScope.$broadcast('refresh');
					});
			});
		};
	});
}