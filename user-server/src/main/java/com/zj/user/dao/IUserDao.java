package com.zj.user.dao;

import java.util.List;

import com.zj.user.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserDao {
	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public List<User> findAll();

	/**
	 * 条件查询
	 * 
	 * @param user
	 * @return
	 */
	public List<User> find(User user);

	/**
	 * 登录
	 * 
	 * @param user
	 * @return
	 */
	public User findByAccountPwd(User user);

	/**
	 * 会员注册
	 * 
	 * @param user
	 * @return
	 */
	public Integer insert(User user);

	/**
	 * 修改会员的密码
	 *
	 * @param uid
	 * @param opwd
	 * @param npwd
	 * @return
	 */
	public Integer updatePwd(@Param("uid") Integer uid, @Param("opwd") String opwd, @Param("npwd") String npwd);

	/**
	 * 修改会员的姓名，头像，性别
	 * 
	 * @param user
	 * @return
	 */
	public Integer update(User user);

	/**
	 * 修改会员的电话，邮箱
	 * 
	 * @param user
	 * @return
	 */
	public Integer updateMajor(User user);

	/**
	 * 总记录数
	 * 
	 * @return
	 */
	public Integer totalNum();

	public User findById(Integer uid);
}
