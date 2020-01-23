package com.naver.todo.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.naver.todo.enums.TodoType;

public class Todo {
	private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");

	private long id;
	private String title;
	private String name;
	private int sequence;
	private TodoType type;
	private LocalDateTime registrationDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public TodoType getType() {
		return type;
	}

	public void setType(TodoType type) {
		this.type = type;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public String getFormattedRegistrationDate() {
		return registrationDate.format(FORMATTER);
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", name=" + name + ", sequence=" + sequence + ", type=" + type
			+ ", registrationDate=" + registrationDate + "]";
	}
}
