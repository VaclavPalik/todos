<!DOCTYPE html>
<html ng-app="todos">
<head>
<meta charset="UTF-8">
<title>Todos</title>
<link rel="stylesheet"
	href="resources/bower_components/uikit/css/uikit.almost-flat.min.css" />
<link rel="stylesheet"
	href="resources/bower_components/uikit/css/components/datepicker.almost-flat.min.css" />
<script src="resources/bower_components/jquery/dist/jquery.js"></script>
<script src="resources/bower_components/uikit/js/uikit.min.js"></script>
<script src="resources/bower_components/uikit/js/components/datepicker.min.js"></script>
<script src="resources/bower_components/angular/angular.js"></script>

<script src="resources/js/app.js"></script>
<script src="resources/js/app/listTodos.js"></script>
<script src="resources/js/app/createTodo.js"></script>
<script src="resources/js/app/updateTodo.js"></script>
<script src="resources/js/app/deleteTodo.js"></script>
</head>
<body>
	<div
		class="uk-container uk-container-center uk-margin-top uk-margin-large-bottom">
		<div class="uk-grid" data-uk-grid-margin>
			<div class="uk-width-1-1">
				<h1 class="uk-heading-large">Todo list</h1>

			</div>
		</div>
		<nav class="uk-navbar">
			<ul class="uk-navbar-nav">
				<li><a href="#createNew" data-uk-modal>Create new</a></li>
			</ul>
		</nav>
		<table class="uk-table uk-table-striped">
			<thead>
				<tr>
					<th>#</th>
					<th>Description</th>
					<th>Created on</th>
					<th>Resolve until</th>
					<th>Resolved</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody ng-controller="listTodos">
				<tr ng-repeat="todo in todos">
					<td>{{$index + 1}}</td>
					<td>{{todo.description}}</td>
					<td>{{todo.createdOn|date:'dd.MM.yyyy HH:mm:ss'}}</td>
					<td>{{todo.resolveUntil|date:'dd.MM.yyyy'}}</td>
					<td>{{todo.resolved}}</td>
					<td><a href="#edit" data-uk-modal ng-click="passData(todo)"><i class="uk-icon-edit"></i></a> <a href="#" ng-controller="deleteTodo" ng-click="executeDelete(todo.id)"><i class="uk-icon-remove"></i></a></td>
				</tr>
			</tbody>
		</table>

		<div id="createNew" class="uk-modal">
			<div class="uk-modal-dialog">
				<a class="uk-modal-close uk-close"></a>
				<h2>Create new Todo</h2>
				<form id="createNewForm" class="uk-form uk-form-horizontal" name="createNewForm" ng-submit="sendForm($event)" ng-controller="createTodo">
					<div class="uk-form-row">
						<label class="uk-form-label" for="description">Description</label>
						<div class="uk-form-controls"><input type="text" name="description" ng-model="description"></div>
					</div>
					<div class="uk-form-row">
						<label class="uk-form-label" for="resolveUntil">Resolve until</label>
						<div class="uk-form-controls"><input type="text" name="resolveUntil" ng-model="resolveUntil" data-uk-datepicker></div>
					</div>
					<div class="uk-form-row">
						<div class="uk-form-controls"><button class="uk-button uk-button-primary" type="submit">Create</button></div>
					</div>
				</form>
			</div>
		</div>
		<div id="edit" class="uk-modal">
			<div class="uk-modal-dialog">
				<a class="uk-modal-close uk-close"></a>
				<h2>Edit Todo</h2>
				<form class="uk-form uk-form-horizontal" id="editForm" name="editForm" ng-submit="sendForm($event)" ng-controller="updateTodo">
					<div class="uk-form-row">
						<label class="uk-form-label" for="description">Description</label>
						<div class="uk-form-controls"><input type="text" name="description" ng-model="todo.description"></div>
					</div>
					<div class="uk-form-row">
						<label class="uk-form-label" for="resolveUntil">Resolve until</label>
						<div class="uk-form-controls"><input type="text" name="resolveUntil" ng-model="todo.resolveUntil" data-uk-datepicker></div>
					</div>
					<div class="uk-form-row">
						<label class="uk-form-label" for="resolved">Resolved</label>
						<div class="uk-form-controls"><input type="checkbox" name="resolved" ng-model="todo.resolved"></div>
					</div>
					<div class="uk-form-row">
						<div class="uk-form-controls"><button class="uk-button uk-button-primary" type="submit">Edit</button></div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>