package com.zj.user.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zj.user.entity.Admin;
import com.zj.user.util.SessionKey;
import org.springframework.web.servlet.HandlerInterceptor;

public class AdmInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Admin admin = (Admin) request.getSession().getAttribute(SessionKey.CURRENT_ADMIN);
		System.out.println(admin);
		if (admin == null) {
			// 未登录，重定向到登录页
			response.sendRedirect("/zyl/back");
			return false;
		}
		return true;
	}
}
