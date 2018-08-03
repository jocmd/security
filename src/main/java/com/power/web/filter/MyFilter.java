package com.power.web.filter;

import java.io.IOException;

import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;
//@Component
public class MyFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
           System.out.println(" MyFilter init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
        long time1 = new Date().getTime();
        System.out.println("MyFilter start 开始时间："+time1);
        chain.doFilter(request, response);
        long time2 = new Date().getTime();
        System.out.println("MyFilter stop 结束时间："+time2);
        System.out.println("耗时："+(time2-time1));
	}

	@Override
	public void destroy() {
        System.out.println(" my filter destroy");
	}

}
