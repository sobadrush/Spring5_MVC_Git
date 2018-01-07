package com.ctbc.vo;

import java.io.Serializable;

public class EmpVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer empNo;
	private String empName;
	private String empJob;
	private java.sql.Date empHireDate;
	private Integer deptNo;
	private DeptVO dept;
	
	public EmpVO() {
		super();
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpJob() {
		return empJob;
	}

	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}

	public java.sql.Date getEmpHireDate() {
		return empHireDate;
	}

	public void setEmpHireDate(java.sql.Date empHireDate) {
		this.empHireDate = empHireDate;
	}

	public Integer getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	public DeptVO getDept() {
		return dept;
	}

	public void setDept(DeptVO dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "EmpVO [empNo=" + empNo + ", empName=" + empName + ", empJob=" + empJob + ", empHireDate=" + empHireDate + ", deptNo=" + deptNo + "]";
	}

}
