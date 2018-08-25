package com.encore.enc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncFilter implements Filter{
	String encType;
	
	@Override
	public void destroy() {
		//System.out.println("destroy()");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse reqs, FilterChain chain)
			throws IOException, ServletException {
		//System.out.println("doFilter()");
		
		if(encType != null) { //web.xml에 encType이 정의 되었다면
			req.setCharacterEncoding(encType);	
		}else {
			req.setCharacterEncoding("UTF-8");	
		}
		
		chain.doFilter(req, reqs); //호출 해야지 화면이 나온다, 다른 필터 혹은 요청페이지와 연결 진행
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		//System.out.println("init()");
		
		//config ===> web.xml에 정의된 param을 읽기
		encType = config.getInitParameter("encType");
	}
	
}//class End
