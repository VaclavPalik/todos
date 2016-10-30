package io.github.vaclavpalik.todos.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getResolveUntil() {
		return resolveUntil;
	}

	public void setResolveUntil(LocalDate resolveUntil) {
		this.resolveUntil = resolveUntil;
	}

	public boolean isResolved() {
		return resolved;
	}

	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	
	public boolean isAfterDeadline() {
		return !resolved && LocalDate.now().compareTo(resolveUntil)>0;
	}
}
