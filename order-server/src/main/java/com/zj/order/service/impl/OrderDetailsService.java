package com.zj.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zj.order.dao.IOrderDetailsDao;
import com.zj.order.entity.OrderDetails;
import com.zj.order.entity.ResponseJson;
import com.zj.order.service.IOrderDetailsService;

@Service
public class OrderDetailsService implements IOrderDetailsService {
	@Autowired
	IOrderDetailsDao orderDetailsDao;

	@Override
	public ResponseJson findByOid(Long oid) {
		List<OrderDetails> listOrderDetails;
		try {
			listOrderDetails = orderDetailsDao.findByOid(oid);
			return new ResponseJson(200, "获取成功", listOrderDetails, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}
}
