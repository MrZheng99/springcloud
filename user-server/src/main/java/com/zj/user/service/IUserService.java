package com.zj.user.service;

import javax.servlet.http.HttpSession;

import com.zj.user.entity.ResponseJson;
import com.zj.user.entity.User;
import org.springframework.web.multipart.MultipartFile;



public interface IUserService {
	/**
	 * 用户登录
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	public ResponseJson login(User user, String code, HttpSession session);

	public ResponseJson findAll();

	public ResponseJson find(User user);

	public ResponseJson insert(User user);

	/**
	 * 用户修改信息
	 * 
	 * @param user
	 * @param session
	 * @param  file
	 * @return
	 */
	public ResponseJson update(MultipartFile file,User user, HttpSession session);
	
	/**
	 * 用户修改关键信息
	 * 
	 * @param user
	 * @return
	 */
	public ResponseJson updateMajor(User user);
	/**
	 * 用户修改密码
	 * 
	 * @param id
	 * @param opwd
	 * @param npwd
	 * @return
	 */
	public ResponseJson updatePwd(Integer id, String opwd, String npwd);

	public Boolean find(String account);

	public ResponseJson insert(HttpSession session);

}
