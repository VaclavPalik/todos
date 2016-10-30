package io.github.vaclavpalik.todos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResorceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3536164760297917763L;

}
