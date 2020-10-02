package com.zj.user.service;

import com.zj.user.entity.Address;
import com.zj.user.entity.ResponseJson;

public interface IAddressService {
	public ResponseJson findCurrent(Integer uid);
	
	public ResponseJson insert(Address address);
	
	public ResponseJson update(Address address);

	public ResponseJson updateFlag(Address address);
	
	public ResponseJson deleteByAid(Integer aid);
}
