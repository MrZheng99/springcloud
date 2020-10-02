package com.zj.user.dao;

import java.util.List;

import com.zj.user.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IAdminDao {
	/**
	 * 查询所有普通和超级管理员
	 * 
	 * @return
	 */
	public List<Admin> findAll();

	/**
	 * 按照条件查询管理员
	 * 
	 * @param admin
	 * @return
	 */
	public List<Admin> find(Admin admin);

	/**
	 * 登录
	 * 
	 * @param admin
	 * @return
	 */
	public Admin findByAccountPwdRole(Admin admin);

	/**
	 * 添加管理员
	 * 
	 * @param admin
	 * @return
	 */
	public Integer insert(Admin admin);

	/**
	 * 修改管理员信息
	 * 
	 * @param admin
	 * @return
	 */
	public Integer update(Admin admin);

	/**
	 * 修改管理员的密码
	 * 
	 * @param id
	 * @param pwd
	 * @return
	 */
	public Integer updatePwd(@Param("aid") Integer aid, @Param("opwd") String opwd, @Param("npwd") String npwd);

	/**
	 * 总记录数
	 * 
	 * @return
	 */
	public Integer totalNum();

	public Admin findById(Integer aid);

}
