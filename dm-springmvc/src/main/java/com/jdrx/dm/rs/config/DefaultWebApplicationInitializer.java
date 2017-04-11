package com.jdrx.dm.rs.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.IntrospectorCleanupListener;

import javax.servlet.*;
import java.util.EnumSet;


public class DefaultWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
        XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
        webApplicationContext.setConfigLocation("classpath*:META-INF/spring/module-*.xml");

        //add listener
        servletContext.addListener(new ContextLoaderListener(webApplicationContext));
        servletContext.addListener(new IntrospectorCleanupListener());
        servletContext.addListener(new RequestContextListener());

        //add filter
        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST);
        FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("CharacterEncodingFilter", new CharacterEncodingFilter());
        characterEncodingFilter.setInitParameter("encoding", "UTF-8");
        characterEncodingFilter.setInitParameter("forceEncoding", "true");
        characterEncodingFilter.addMappingForUrlPatterns(dispatcherTypes, true, "/*");

        //add servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("mvc", dispatcherServlet);
        dispatcher.setMultipartConfig(new MultipartConfigElement(null, 1024*1024*50, 1024*1024*100, 1024*1024*10));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
	}

}
