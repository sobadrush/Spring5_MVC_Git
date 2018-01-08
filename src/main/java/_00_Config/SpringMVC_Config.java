package _00_Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * http://blog.csdn.net/lchpersonal521/article/details/53112728
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.ctbc.controller" })
public class SpringMVC_Config implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
//		registry.jsp("WEB-INF/pages"/* prefix */, ".jsp"/* suffix */);
//		registry.viewResolver(new InternalResourceViewResolver());
		registry.jsp("/WEB-INF/pages/", ".jsp");// 等於上面兩行
		
//		registry.enableContentNegotiation(new MappingJackson2JsonView());
	}

}

