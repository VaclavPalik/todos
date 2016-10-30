package io.github.vaclavpalik.todos.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import io.github.vaclavpalik.todos.model.Todo;

@Controller
@RequestMapping("/")
public class TodoController {
	private Map<Integer, Todo> todos = new ConcurrentHashMap<>();

	@RequestMapping(value = "createTodo", method = RequestMethod.POST)
	public ModelAndView createTodo(@ModelAttribute Todo todo) {
		todos.put(todo.getId(), todo);
		return new ModelAndView("operationSuccessful");
	}

	@RequestMapping("listTodos")
	public List<Todo> listTodos() {
		return todos.values().stream()
				.sorted(Comparator.comparing(Todo::getResolveUntil).thenComparing(Todo::getCreatedOn))
				.collect(Collectors.toList());
	}

	@RequestMapping(value = "deleteTodo/{id}", method = RequestMethod.DELETE)
	public ModelAndView deleteTodo(@PathVariable int id) {
		if (todos.containsKey(id)) {
			todos.remove(id);
			return new ModelAndView("operationSuccessful");
		} else {
			throw new ResorceNotFoundException();
		}
	}

	@RequestMapping(value = "updateTodo/{id}", method = RequestMethod.PUT)
	public ModelAndView updateTodo(@PathVariable int id, @ModelAttribute Todo newValue) {
		if (todos.containsKey(id)) {
			Todo todo = todos.get(id);
			todo.setDescription(newValue.getDescription());
			todo.setResolveUntil(newValue.getResolveUntil());
			todo.setResolved(newValue.isResolved());
			return new ModelAndView("operationSuccessful");
		} else {
			throw new ResorceNotFoundException();
		}
	}
}
