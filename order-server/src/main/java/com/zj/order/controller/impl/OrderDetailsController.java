package com.zj.order.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zj.order.controller.IOrderDetailsController;
import com.zj.order.entity.ResponseJson;
import com.zj.order.service.IOrderDetailsService;

@RestController
@RequestMapping("orderDetails")
public class OrderDetailsController implements IOrderDetailsController {
	@Autowired
	IOrderDetailsService orderDetailsService;

	@Override
	@RequestMapping("/findByOid")
	public ResponseJson findByOid(@RequestParam Long oid) {
		return orderDetailsService.findByOid(oid);
	}
}
