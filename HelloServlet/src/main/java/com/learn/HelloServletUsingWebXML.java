package com.learn;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class HelloServletUsingWebXML extends GenericServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("Init method of HelloServletUsingWebXML");
	};
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		res.getWriter().append("HelloServletUsingWebXML Servlet");
	}
	
	@Override
	public void destroy() {
		System.out.println("destory method of HelloServletUsingWebXML");
	}

}
