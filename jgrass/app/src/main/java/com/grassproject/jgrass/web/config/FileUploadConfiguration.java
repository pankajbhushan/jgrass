package com.grassproject.jgrass.web.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class FileUploadConfiguration extends WebMvcConfigurerAdapter implements WebApplicationInitializer{

	private String TMP_FOLDER = "/tmp";
	private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;

	@Override
	public void onStartup(ServletContext sc) throws ServletException {

		ServletRegistration.Dynamic appServlet = sc.addServlet("mvc",
				new DispatcherServlet(new GenericWebApplicationContext()));

		appServlet.setLoadOnStartup(1);

		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER, MAX_UPLOAD_SIZE,
				MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);

		appServlet.setMultipartConfig(multipartConfigElement);
	}

	/*@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(100000);
		return multipartResolver;
	}*/
	
	@Bean(name = "multipartResolver")
	public StandardServletMultipartResolver multipartResolver() {
	    return new StandardServletMultipartResolver();
	}
}
