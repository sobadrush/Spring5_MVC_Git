package com.ctbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ctbc.vo.DeptVO;
import com.ctbc.vo.EmpVO;

public class MyRowMappers {
	
	static class EmpRowMapper implements RowMapper<EmpVO> {
		@Override
		public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpVO empvo = new EmpVO();
			empvo.setEmpNo(rs.getInt("empno"));
			empvo.setEmpName(rs.getString("ename"));
			empvo.setEmpJob(rs.getString("job"));
			empvo.setDeptNo(rs.getInt("deptno"));
			empvo.setEmpHireDate(rs.getDate("hiredate"));
			return empvo;
		}
	}
	
	static class DeptRowMapper implements RowMapper<DeptVO> {
		@Override
		public DeptVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			DeptVO vo = null;
			vo = new DeptVO();
			vo.setDeptNo(rs.getInt("deptno"));
			vo.setDeptName(rs.getString("dname"));
			vo.setDeptLoc(rs.getString("loc"));
			return vo;
		}

	}
}
