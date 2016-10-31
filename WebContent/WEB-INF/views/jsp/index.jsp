<!DOCTYPE html>
<html ng-app="todos">
<head>
<meta charset="UTF-8">
<title>Todos</title>
<link rel="stylesheet"
	href="resources/bower_components/uikit/css/uikit.min.css" />
<script src="resources/bower_components/jquery/dist/jquery.js"></script>
<script src="resources/bower_components/uikit/js/uikit.min.js"></script>
<script src="resources/bower_components/angular/angular.js"></script>

<script src="resources/js/app.js"></script>
<script src="resources/js/app/listTodos.js"></script>
<script src="resources/js/app/createTodo.js"></script>
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
		<table>
			<thead>
				<tr>
					<th colspan="4">Todos</th>
				</tr>
			</thead>
			<tbody ng-controller="listTodos">
				<tr ng-repeat="todo in todos">
					<td>{{$index + 1}}</td>
					<td>{{todo.description}}</td>
					<td>{{todo.createdOn}}</td>
					<td>{{todo.resolveUntil}}</td>
					<td>{{todo.resolved}}</td>
				</tr>
			</tbody>
		</table>

		<div id="createNew" class="uk-modal">
			<div class="uk-modal-dialog">
				<a class="uk-modal-close uk-close"></a>
				<form id="createNewForm" name="createNewForm" ng-submit="sendForm($event)" ng-controller="createTodo">
					<input type="text" name="description" ng-model="description">
					<input type="text" name="resolveUntil" ng-model="resolveUntil">
					<input type="submit" value="Create">
					{{description}}
				</form>
			</div>
		</div>
	</div>
</body>
</html>