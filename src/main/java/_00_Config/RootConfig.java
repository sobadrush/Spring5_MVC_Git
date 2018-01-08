package _00_Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = { "com.ctbc.dao" })
@PropertySource(value = "classpath:/connectionData.properties", encoding = "utf-8")
public class RootConfig {

	@Autowired
	private Environment env; // https://www.jianshu.com/p/49e950b0b008

	@Bean
	public DataSource driverManagerDS() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl(env.getProperty("ds.url"));
		ds.setUsername(env.getProperty("ds.username"));
		ds.setPassword(env.getProperty("ds.password"));
		ds.setDriverClassName(env.getProperty("ds.drivername"));
		return ds;
	}

	@Bean
	public JdbcOperations myJdbcTemplate(DataSource ds) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(ds);
		return jdbcTemplate;
	}

}
