package com.naver.todo.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.todo.dao.TodoDao;
import com.naver.todo.dto.Todo;

@WebServlet("/todos")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.sendRedirect("/todo/main");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Todo todo = new Todo();
		todo.setName(request.getParameter("name"));
		todo.setTitle(request.getParameter("title"));
		todo.setSequence(Integer.parseInt(request.getParameter("priority")));

		TodoDao todoDao = new TodoDao();
		todoDao.addTodo(todo);

		response.sendRedirect("/todo/main");
	}

}
