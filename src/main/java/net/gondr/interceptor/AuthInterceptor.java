package net.gondr.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		
		HttpSession session = req.getSession();
		
		if(session != null) {
			Object user = session.getAttribute("user");
			if( user != null ) return true;
		}
		
		res.sendRedirect("/user/login");
		return false;
	}
	

}
