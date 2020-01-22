package kr.or.connect.daoexam.dao;

import static kr.or.connect.daoexam.dao.RoleDaoSqls.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.daoexam.dto.Role;

@Repository
public class RoleDao {
	private final NamedParameterJdbcTemplate jdbcTemplate;
	private final SimpleJdbcInsert simpleJdbcInsert;
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

	public RoleDao(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("role");
	}

	public List<Role> selectAll() {
		return jdbcTemplate.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
	}

	public int insert(Role role) {
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(role);
		return simpleJdbcInsert.execute(sqlParameterSource);
	}

	public int update(Role role) {
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(role);
		return jdbcTemplate.update(UPDATE, sqlParameterSource);
	}

	public int deleteById(int id) {
		Map<String, ?> params = Collections.singletonMap("roleId", id);
		return jdbcTemplate.update(DELETE_BY_ROLE_ID, params);
	}

	public Role selectById(int id) {
		try {
			Map<String, ?> params = Collections.singletonMap("roleId", id);
			return jdbcTemplate.queryForObject(SELECT_BY_ROLE_ID, params, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
