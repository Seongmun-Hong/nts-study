package com.naver.todo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.todo.dao.TodoDao;
import com.naver.todo.dto.Todo;

@WebServlet("/todos")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 530873942937219122L;
	private static final TodoDao TODO_DAO = new TodoDao();
	private static final int INSERT_SUCCESS = 1;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			Todo todo = new Todo();
			todo.setName(request.getParameter("name"));
			todo.setTitle(request.getParameter("title"));
			todo.setSequence(Integer.parseInt(request.getParameter("sequence")));

			int insertCount = TODO_DAO.addTodo(todo);

			if (insertCount == INSERT_SUCCESS) {
				response.sendRedirect("/todo/main");
			} else {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		} catch (NumberFormatException numberFormatException) {
			numberFormatException.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
