package com.config;


import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/*
 * public class ServletContainerInitConfig extends
 * AbstractDispatcherServletInitializer{
 * 
 * @Override protected WebApplicationContext createServletApplicationContext() {
 * // TODO Auto-generated method stub AnnotationConfigWebApplicationContext ctx
 * = new AnnotationConfigWebApplicationContext();
 * ctx.register(SpringMvcConfig.class); return ctx; }
 * 
 * @Override protected String[] getServletMappings() { // TODO Auto-generated
 * method stub return new String[] {"/"}; }
 * 
 * @Override protected WebApplicationContext createRootApplicationContext() { //
 * TODO Auto-generated method stub return null; }
 * 
 * }
 */
public class ServletContainerInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {SpringConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {SpringMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	
}