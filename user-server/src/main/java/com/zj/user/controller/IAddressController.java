package com.zj.user.controller;

import javax.servlet.http.HttpSession;

import com.zj.user.entity.Address;
import com.zj.user.entity.ResponseJson;
import com.zj.user.entity.User;

public interface IAddressController {
	public ResponseJson findCurrent(User user);

	public ResponseJson update(Address address, HttpSession session);

	public ResponseJson insert(Address address, HttpSession session);

	public ResponseJson updateFlag(Address address, HttpSession session);

	public ResponseJson deleteByAid(Address address);

}
