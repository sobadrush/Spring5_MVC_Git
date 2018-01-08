package test.datasource;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import _00_Config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
public class DatasourceTest {

//	@Autowired
	@Resource(name = "driverManagerDS")
	private DataSource ds;

	private static String MSSQL_NAME;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		MSSQL_NAME = "Microsoft SQL Server";
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
		Connection conn = null;
		try {
			conn = ds.getConnection();
			String prodName = conn.getMetaData().getDatabaseProductName();
			System.out.println(prodName);
			assertEquals("連線失敗!!", MSSQL_NAME, prodName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}



