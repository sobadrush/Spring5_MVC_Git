package com.ctbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctbc.dao.EmpDAO;
import com.ctbc.vo.EmpVO;

@Controller
@RequestMapping(value = "/empCRUD")
public class EmpController {

	public EmpController() {
		System.out.println("EmpController be constructor");
	}

	@Autowired
	private EmpDAO empDAO;

	@RequestMapping(value = "/testTest", method = { RequestMethod.GET })
	public String testTest() {
		System.out.println("123");
		return "success";
	}

	@ResponseBody
	@RequestMapping(value = "/getAllEmps", method = { RequestMethod.GET }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<EmpVO> getAllEmps(@RequestParam("isEager") boolean isEager) {
		System.out.println(" isEager >>> " + isEager);
		return empDAO.getAll(isEager/* isEager */);
	}

	@ResponseBody
	@RequestMapping(value = "/getAllEmps_By_PathVarizble/{lazyStatus}", method = { RequestMethod.GET }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<EmpVO> getAllEmps_By_PathVarizble(@PathVariable("lazyStatus") boolean lazyStatus) {
		System.out.println(" lazyStatus >>> " + lazyStatus);
		return empDAO.getAll(lazyStatus/* isEager */);
	}
	
	
}
