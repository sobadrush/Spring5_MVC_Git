package com.ctbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import com.ctbc.dao.MyRowMappers.DeptRowMapper;
import com.ctbc.dao.MyRowMappers.EmpRowMapper;
import com.ctbc.vo.DeptVO;
import com.ctbc.vo.EmpVO;

@Repository
public class EmpDAO {

	private static final String GET_ALL_STMT = "SELECT * FROM emp_TB13";
	private static final String GET_EMPS_BY_DEPTNO = "SELECT * FROM dept_TB13 WHERE deptno = (" +
														   " SELECT deptno FROM emp_TB13 WHERE empno = ? " +
													  ")";

	@Autowired
	private JdbcOperations jdbcTemplate;

//	private static final MyRowMappers myRowMappers = new MyRowMappers();
	
	public List<EmpVO> getAll(boolean isEager) {
		List<EmpVO> eList = jdbcTemplate.query(GET_ALL_STMT, new EmpRowMapper());

		if (isEager == true) {
			for (EmpVO empVO : eList) {
				DeptVO deptVO = jdbcTemplate.queryForObject(GET_EMPS_BY_DEPTNO, new DeptRowMapper(), empVO.getEmpNo());
				empVO.setDept(deptVO);
			}
		}

		return eList;
	}
}
