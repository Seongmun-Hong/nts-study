package com.naver.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.naver.todo.dto.Todo;

public class TodoDao {

//	private static final String DB_URL = "jdbc:mysql://10.113.116.52:13306/intern04?serverTimezone=Asia/Seoul&useSSL=false";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
//	private static final String DB_USER = "intern04";
//	private static final String DB_PASSWORD = "intern04";
	private static final String DB_USER = "connectuser";
	private static final String DB_PASSWORD = "connect123!@#";

	public int addTodo(Todo todo) {
		int insertCount = 0;
		String sql = "INSERT INTO todo (title, name, sequence) VALUES ( ?, ?, ? )";

		try (Connection conn = getNewConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getName());
			ps.setInt(3, todo.getSequence());
			insertCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insertCount;
	}

	public List<Todo> getTodos() {
		List<Todo> list = new ArrayList<>();
		String sql = "SELECT id, title, name, sequence, type, DATE_FORMAT(regdate, '%Y.%m.%d') as regDate FROM todo ORDER BY sequence, regdate desc";

		try (Connection conn = getNewConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Todo todo = new Todo();
					todo.setId(rs.getLong(1));
					todo.setTitle(rs.getString(2));
					todo.setName(rs.getString(3));
					todo.setSequence(rs.getInt(4));
					todo.setType(rs.getString(5));
					todo.setRegdate(rs.getString(6));
					list.add(todo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int updateTodo(Todo todo) {
		int updateCount = 0;
		String sql = "UPDATE todo SET type = ? WHERE id = ? ";

		try (Connection conn = getNewConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, getNextTodoType(todo.getType()));
			ps.setLong(2, todo.getId());
			updateCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateCount;
	}

	private Connection getNewConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}

	private String getNextTodoType(String currentType) {
		if ("TODO".equals(currentType)) {
			return "DOING";
		} else if ("DOING".equals(currentType)) {
			return "DONE";
		}
		return null;
	}

}
