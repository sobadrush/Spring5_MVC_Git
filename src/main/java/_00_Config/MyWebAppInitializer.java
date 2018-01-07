package _00_Config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * http://blog.csdn.net/xiao__gui/article/details/46803193
 */
public class MyWebAppInitializer implements WebApplicationInitializer {  
	  
    /** 
     * Servlet容器启动时会自动运行该方法 
     */  
    @Override  
    public void onStartup(ServletContext servletContext) throws ServletException {  
  
    	 AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();  
         rootContext.register(RootConfig.class);  
         servletContext.addListener(new ContextLoaderListener(rootContext));  
            
         AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();  
         webContext.register(SpringMVC_Config.class);  
         ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));  
         registration.setLoadOnStartup(1);  
         // registration.addMapping("/");  
         registration.addMapping("/spring_mvc/*");  
    }  
}  

// Question :  / 和 /*　有什么区别？
// Ans : / 会拦截除了jsp 以外的所有url，/* 会拦截所有url，包括jsp。
// 例如：在webroot下面有一个test.jsp,当 DispatcherServlet 配置映射 / 时，浏览器输入：http://localhost:8083/test.jsp 这个jsp是可以直接访问的
// ，并且不经过DispatcherServlet ，而当DispatcherServlet 配置映射/* 时，这个请求就会被DispatcherServlet 拦截



