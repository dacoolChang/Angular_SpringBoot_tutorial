package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

public class CustomFilter2 extends GenericFilterBean {
	Logger logger = LoggerFactory.getLogger(CustomFilter2.class);
    @Override
    public void doFilter(
      ServletRequest request, 
      ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    	logger.info("Custom Filter2");
        chain.doFilter(request, response);
    }
}
