package com.zj.user.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.zj.user.controller.IAddressController;
import com.zj.user.entity.Address;
import com.zj.user.entity.ResponseJson;
import com.zj.user.entity.User;
import com.zj.user.service.IAddressService;
import com.zj.user.util.SessionKey;

@RestController
@RequestMapping("address")
public class AddressController implements IAddressController {
	@Autowired
	IAddressService addressService;

	@Override
	@RequestMapping("/findCurrent")
	public ResponseJson findCurrent(@SessionAttribute(name = SessionKey.CURRENT_USER) User user) {
		return addressService.findCurrent(user.getUid());
	}

	@Override
	@PostMapping("/insert")
	public ResponseJson insert(@RequestBody Address address, HttpSession session) {
		Object obj = session.getAttribute(SessionKey.CURRENT_USER);
		User user = (User) obj;
		address.setUid(user.getUid());
		return addressService.insert(address);
	}

	@Override
	@PostMapping("/update")
	public ResponseJson update(@RequestBody Address address, HttpSession session) {
		Object obj = session.getAttribute(SessionKey.CURRENT_USER);
		User user = (User) obj;
		address.setUid(user.getUid());
		return addressService.update(address);
	}

	@Override
	@PostMapping("/updateFlag")
	public ResponseJson updateFlag(@RequestBody Address address, HttpSession session) {
		Object obj = session.getAttribute(SessionKey.CURRENT_USER);
		User user = (User) obj;
		address.setUid(user.getUid());
		return addressService.updateFlag(address);
	}

	@Override
	@PostMapping("/deleteByAid")
	public ResponseJson deleteByAid(@RequestBody Address address) {
		Integer aid = address.getAid();
		return addressService.deleteByAid(aid);
	}
}
