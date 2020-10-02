package com.zj.user.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zj.user.controller.IHomeController;
import com.zj.user.entity.Admin;
import com.zj.user.entity.ResponseJson;
import com.zj.user.entity.User;
import com.zj.user.service.impl.AdminService;
import com.zj.user.service.impl.UserService;

@Controller
public class HomeController implements IHomeController {
	@Autowired
	AdminService adminService;
	@Autowired
	UserService userService;

	@Override
	@RequestMapping("/back/super")
	public ModelAndView backSuper() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/back/manager/supermanager.html");
		return mav;
	}

	@Override
	@RequestMapping("/back/normal")
	public ModelAndView backNormal() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/back/manager/normalmanager.html");
		return mav;
	}

	@Override
	@RequestMapping("/front/index")
	public ModelAndView front() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/front/index.html");
		return mav;
	}

	@Override
	@RequestMapping("/back")
	public ModelAndView backIndex() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/back/login.html");
		return mav;
	}

	@Override
	@RequestMapping("/front")
	public ModelAndView frontIndex() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/front/login.html");
		return mav;
	}

	@Override
	@ResponseBody
	@PostMapping("/back/login")
	public ResponseJson loginBack(@RequestBody Admin admin, HttpSession session) {
		return adminService.login(admin, session);
	}

	@Override
	@ResponseBody
	@PostMapping("/front/login/{code}")
	public ResponseJson loginFront(@RequestBody User user, @PathVariable String code, HttpSession session) {
		return userService.login(user, code, session);
	}

}
