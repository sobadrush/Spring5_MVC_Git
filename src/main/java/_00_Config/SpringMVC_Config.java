package _00_Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 靜態資源映射：
		// (1) xml 方式 >> https://www.jianshu.com/p/81d613c63d52
		// (2) Java方式 >> https://blog.coding.net/blog/spring-static-resource-process
		// 【說明】前端 <link rel="stylesheet" href="<%=request.getContextPath()%>/spring_mvc/resources/css/tableStyle.css" />
		//  由於配置了DispatcherServlet欄截請求，故必須有addResourceHandlers設定告訴DispatcherServlet必須要有一個映射管道讓外
		//  部直接訪問靜態資源(css , js , jpg ...etc )
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
	}

}



