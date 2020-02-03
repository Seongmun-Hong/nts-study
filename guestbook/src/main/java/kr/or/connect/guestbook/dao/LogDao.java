package kr.or.connect.guestbook.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.guestbook.dto.Log;

@Repository
public class LogDao {

	private final NamedParameterJdbcTemplate jdbcTemplate;
	private final SimpleJdbcInsert insertAction;

	public LogDao(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
			.withTableName("log")
			.usingGeneratedKeyColumns("id");
	}

	public long insert(Log log) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(log);
		return insertAction.executeAndReturnKey(params).longValue();

	}

}
