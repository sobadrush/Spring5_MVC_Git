package com.ctbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.ctbc.dao.MyRowMappers.DeptRowMapper;
import com.ctbc.vo.DeptVO;

@Repository
public class DeptDAO {

	private static final String GET_ALL_STMT = "SELECT * FROM dept_TB13";

	@Resource(name = "myJdbcTemplate")
	private JdbcOperations jdbcTemplate;

	public List<DeptVO> getAll() {
		return jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(GET_ALL_STMT);
				return pstmt;
			}
		}, new DeptRowMapper());
	}

}
