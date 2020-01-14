package com.naver.todo.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.todo.dao.TodoDao;
import com.naver.todo.dto.Todo;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");

		TodoDao todoDao = new TodoDao();
		List<Todo> todoList = todoDao.getTodos();

		request.setAttribute("todoList", todoList);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/main.jsp");
		requestDispatcher.forward(request, response);
	}

}