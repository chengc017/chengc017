package com.sohu.business.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {
	private final static Logger logger=LoggerFactory.getLogger(LogFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		String scheme=request.getScheme();
		

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
