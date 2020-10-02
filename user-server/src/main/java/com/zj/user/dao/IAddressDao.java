package com.zj.user.dao;

import java.util.List;

import com.zj.user.entity.Address;
import org.springframework.stereotype.Repository;



@Repository
public interface IAddressDao {
	/*
	 * 查询当前用户的地址信息
	 * 
	 */
	public List<Address> findCurrent(Integer uid); 
	
	public Integer insert(Address address);
	
	public Integer update(Address address);
	
	public Integer updateFlag(Address address);
	
	public Integer deleteByAid(Integer aid);

}
