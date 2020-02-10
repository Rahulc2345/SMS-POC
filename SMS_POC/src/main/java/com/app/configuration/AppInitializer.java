package com.app.configuration;



import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	  
    private static final String LOCATION = "C:\\Users\\rahul.chaurasia\\poc_workspace\\POC_Project\\src\\main\\webapp\\WEB-INF\\files";
    private static final long MAX_FILE_SIZE = 1024 * 1024 * 25; 
    private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 30;
    private static final int FILE_SIZE_THRESHOLD = 0;
	
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{AppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	private MultipartConfigElement getMultiPartConfigElement(){
		MultipartConfigElement configElement=new MultipartConfigElement(LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
		return configElement;
	}
	
	 @Override
	 protected void customizeRegistration(ServletRegistration.Dynamic registration) {
	    registration.setMultipartConfig(getMultiPartConfigElement());
	 }
	 
	
}
