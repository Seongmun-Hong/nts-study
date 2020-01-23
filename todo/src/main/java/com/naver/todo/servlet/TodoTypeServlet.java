package com.naver.todo.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.naver.todo.dao.TodoDao;
import com.naver.todo.dto.Todo;

@WebServlet("/todos/*")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 8687868997093721058L;
	private static final TodoDao TODO_DAO = new TodoDao();
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static final int UPDATE_SUCCESS = 1;
	private static final int TODO_ID_PART = 1;

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");

		PrintWriter printWriter = response.getWriter();

		try {
			Todo todoWithNextType = getNextTypeTodo(request);

			int updateCount = TODO_DAO.updateTodo(todoWithNextType);

			if (updateCount == UPDATE_SUCCESS) {
				printWriter.print("success");
			} else {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				printWriter.print("존재하지 않는 Todo 목록입니다.");
			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			printWriter.print("Type정보가 올바르지 않습니다.");

		} catch (IllegalStateException illegalStateException) {
			illegalStateException.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			printWriter.print("Done Type의 Todo는 업데이트 할 수 없습니다.");

		} catch (NumberFormatException numberFormatException) {
			numberFormatException.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			printWriter.print("올바르지 않은 형식의 Todo ID 입니다.");

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			printWriter.print("서버 오류 입니다.");
		}
	}

	private Todo getNextTypeTodo(HttpServletRequest request) throws IOException {
		BufferedReader reader = request.getReader();
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();

		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
		}

		Todo todo = OBJECT_MAPPER.readValue(stringBuilder.toString(), Todo.class);

		todo.setId(extractTodoId(request));
		todo.setType(todo.getType().getNextType());

		return todo;
	}

	private long extractTodoId(HttpServletRequest request) throws NumberFormatException {
		String[] pathParts = request.getPathInfo().split("/");
		return Long.parseLong(pathParts[TODO_ID_PART]);
	}
}