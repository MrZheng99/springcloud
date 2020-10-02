package com.zj.user.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.zj.user.entity.Admin;
import com.zj.user.entity.ResponseJson;

public interface IAdminService {
	public ResponseJson findAll();

	public ResponseJson find(Admin admin);

	public ResponseJson insert(MultipartFile file, Admin admin);

	/**
	 * 修改管理员信息
	 * 
	 * @param admin
	 * @return
	 */
	public ResponseJson update(MultipartFile file, Admin admin, HttpSession session);

	/**
	 * 管理员登录
	 * 
	 * @param admin
	 * @param session
	 * @return
	 */
	public ResponseJson login(Admin admin, HttpSession session);


	

	
}
