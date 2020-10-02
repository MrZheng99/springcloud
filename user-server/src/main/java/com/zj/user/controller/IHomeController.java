package com.zj.user.controller;

import javax.servlet.http.HttpSession;

import com.zj.user.entity.Admin;
import com.zj.user.entity.ResponseJson;
import com.zj.user.entity.User;
import org.springframework.web.servlet.ModelAndView;

public interface IHomeController {
	public ModelAndView front();

	public ModelAndView backIndex();

	public ModelAndView frontIndex();

	/**
	 * 后台登录
	 * 
	 * @param admin
	 * @param session
	 * @return
	 */

	ResponseJson loginBack(Admin admin, HttpSession session);

	/**
	 * 前台登录
	 * 
	 * @param user
	 * @param code
	 * @param session
	 * @return
	 */
	ResponseJson loginFront(User user, String code, HttpSession session);

	ModelAndView backSuper();

	ModelAndView backNormal();

}
