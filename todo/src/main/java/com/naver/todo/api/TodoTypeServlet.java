package com.naver.todo.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naver.todo.dao.TodoDao;
import com.naver.todo.dto.Todo;

@WebServlet("/todos/*")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");

		Todo todo = getTodoFromRequestOnlyType(request.getReader());
		todo.setId(getIdFromPathInfo(request.getPathInfo()));

		TodoDao todoDao = new TodoDao();
		todoDao.updateTodo(todo);

		PrintWriter printWriter = response.getWriter();
		printWriter.print("success");
	}

	private long getIdFromPathInfo(String pathInfo) {
		String[] pathParts = pathInfo.split("/");
		return Integer.parseInt(pathParts[1]);
	}

	private Todo getTodoFromRequestOnlyType(BufferedReader reader) throws IOException {
		String line = null;
		StringBuilder sb = new StringBuilder();
		
		while ((line = reader.readLine()) != null)
			sb.append(line);

		return getTodoFromJsonStr(sb.toString());
	}

	private Todo getTodoFromJsonStr(String json) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, Todo.class);
	}
}
