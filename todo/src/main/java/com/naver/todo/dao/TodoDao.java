package com.naver.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.naver.todo.dto.Todo;
import com.naver.todo.enums.TodoType;

public class TodoDao {
	private static final String DB_URL = "jdbc:mysql://10.113.116.52:13306/intern04?serverTimezone=Asia/Seoul&useSSL=false";
	private static final String DB_USER = "intern04";
	private static final String DB_PASSWORD = "intern04";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException classNotFoundException) {
			throw new RuntimeException(classNotFoundException);
		}
	}

	public int addTodo(Todo todo) throws SQLException {
		int insertCount = 0;
		String sql = "INSERT INTO todo (title, name, sequence) VALUES ( ?, ?, ? )";

		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getName());
			ps.setInt(3, todo.getSequence());

			insertCount = ps.executeUpdate();
		}
		return insertCount;
	}

	public List<Todo> getTodos() throws SQLException {
		List<Todo> list = new ArrayList<>();
		String sql = "SELECT id, title, name, sequence, type, "
			+ "regdate AS registrationDate FROM todo ORDER BY regdate, sequence";

		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {
				list = convertToTodoList(rs);
			}
		}
		return list;
	}

	private List<Todo> convertToTodoList(ResultSet resultSet) throws SQLException {
		List<Todo> list = new ArrayList<>();

		while (resultSet.next()) {
			Todo todo = new Todo();
			todo.setId(resultSet.getLong("id"));
			todo.setTitle(resultSet.getString("title"));
			todo.setName(resultSet.getString("name"));
			todo.setSequence(resultSet.getInt("sequence"));
			todo.setType(TodoType.valueOf(resultSet.getString("type")));
			todo.setRegistrationDate(resultSet.getObject("registrationDate", LocalDateTime.class));

			list.add(todo);
		}
		return list;
	}

	public int updateTodo(Todo todo) throws SQLException {
		int updateCount = 0;
		String sql = "UPDATE todo SET type = ? WHERE id = ? ";

		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, todo.getType().toString());
			ps.setLong(2, todo.getId());

			updateCount = ps.executeUpdate();
		}
		return updateCount;
	}
}
