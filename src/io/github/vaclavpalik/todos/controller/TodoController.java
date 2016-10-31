package io.github.vaclavpalik.todos.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import io.github.vaclavpalik.todos.model.Todo;
import io.github.vaclavpalik.todos.view.TodoJsonView;

@RestController
@RequestMapping("/")
public class TodoController {
	private Map<Integer, Todo> todos = new ConcurrentHashMap<>();

	@JsonView(TodoJsonView.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	@RequestMapping(value = "createTodo", method = RequestMethod.POST)
	public Todo createTodo(@ModelAttribute Todo todo) {
		if(todo.getDescription()==null||todo.getResolveUntil()==null){
			throw new NullPointerException();
		}
		todos.put(todo.getId(), todo);
		return todo;
	}

	@JsonView(TodoJsonView.class)
	@RequestMapping("listTodos")
	public List<Todo> listTodos() {
		return todos.values().stream()
				.sorted(Comparator.comparing(Todo::getResolveUntil).thenComparing(Todo::getCreatedOn))
				.collect(Collectors.toList());
	}

	@RequestMapping(value = "deleteTodo/{id}", method = RequestMethod.DELETE)
	public void deleteTodo(@PathVariable int id) {
		if (todos.containsKey(id)) {
			todos.remove(id);
		} else {
			throw new ResorceNotFoundException();
		}
	}

	@RequestMapping(value = "updateTodo/{id}", method = RequestMethod.PUT)
	public void updateTodo(@PathVariable int id, @RequestBody Todo newValue) {
		if (todos.containsKey(id)) {
			Todo todo = todos.get(id);
			todo.setDescription(newValue.getDescription());
			todo.setResolveUntil(newValue.getResolveUntil());
			todo.setResolved(newValue.isResolved());
		} else {
			throw new ResorceNotFoundException();
		}
	}
}
