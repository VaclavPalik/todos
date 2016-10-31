package io.github.vaclavpalik.todos.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonView;

import io.github.vaclavpalik.todos.view.TodoJsonView;

public class Todo {
	private static int counter = 0;

	private int id = ++counter;
	private LocalDateTime createdOn = LocalDateTime.now();
	private String description;
	private LocalDate resolveUntil;
	private boolean resolved = false;

	public Todo(String description, LocalDate resolveUntil) {
		this.description = description;
		this.resolveUntil = resolveUntil;
	}
	
	public Todo(){
		
	}

	@JsonView(TodoJsonView.class)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@DateTimeFormat(iso = ISO.DATE)
	@JsonView(TodoJsonView.class)
	public LocalDate getResolveUntil() {
		return resolveUntil;
	}

	@DateTimeFormat(iso = ISO.DATE)
	public void setResolveUntil(LocalDate resolveUntil) {
		this.resolveUntil = resolveUntil;
	}

	@JsonView(TodoJsonView.class)
	public boolean isResolved() {
		return resolved;
	}

	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

	@JsonView(TodoJsonView.class)
	public int getId() {
		return id;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonView(TodoJsonView.class)
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	
	public boolean isAfterDeadline() {
		return !resolved && LocalDate.now().compareTo(resolveUntil)>0;
	}
}
