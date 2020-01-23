package com.naver.todo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.todo.dao.TodoDao;
import com.naver.todo.dto.GroupedTodoLists;
import com.naver.todo.dto.Todo;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = -1423072805767449214L;
	private static final TodoDao TODO_DAO = new TodoDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		try {
			GroupedTodoLists groupedTodoLists = getGroupedTodoLists();

			request.setAttribute("todoList", groupedTodoLists.getTodoList());
			request.setAttribute("doingList", groupedTodoLists.getDoingList());
			request.setAttribute("doneList", groupedTodoLists.getDoneList());

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

	private GroupedTodoLists getGroupedTodoLists() throws SQLException {
		List<Todo> allTodoList = TODO_DAO.getTodos();

		List<Todo> todoList = new ArrayList<>();
		List<Todo> doingList = new ArrayList<>();
		List<Todo> doneList = new ArrayList<>();

		for (Todo todo : allTodoList) {
			switch (todo.getType()) {
				case TODO:
					todoList.add(todo);
					break;
				case DOING:
					doingList.add(todo);
					break;
				case DONE:
					doneList.add(todo);
					break;
				default:
					break;
			}
		}

		GroupedTodoLists groupedTodoLists = new GroupedTodoLists();
		groupedTodoLists.setTodoList(todoList);
		groupedTodoLists.setDoingList(doingList);
		groupedTodoLists.setDoneList(doneList);

		return groupedTodoLists;
	}
}