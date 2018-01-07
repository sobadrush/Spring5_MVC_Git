package test.dao.empDAO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctbc.dao.EmpDAO;
import com.ctbc.vo.EmpVO;

import _00_Config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
public class EmpDAO_test {

	@Autowired
	private EmpDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(dao.getAll(true /*isEager*/).size());
		for (EmpVO empvo : dao.getAll(true)) {
			System.err.println(empvo);
			System.out.println(empvo.getDept());
			System.out.println("-------------------------");
		}
	}

}
