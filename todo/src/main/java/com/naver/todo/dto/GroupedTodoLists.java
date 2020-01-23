package com.naver.todo.dto;

import java.util.List;

public class GroupedTodoLists {
	private List<Todo> todoList;
	private List<Todo> doingList;
	private List<Todo> doneList;

	public List<Todo> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<Todo> todoList) {
		this.todoList = todoList;
	}

	public List<Todo> getDoingList() {
		return doingList;
	}

	public void setDoingList(List<Todo> doingList) {
		this.doingList = doingList;
	}

	public List<Todo> getDoneList() {
		return doneList;
	}

	public void setDoneList(List<Todo> doneList) {
		this.doneList = doneList;
	}
}
