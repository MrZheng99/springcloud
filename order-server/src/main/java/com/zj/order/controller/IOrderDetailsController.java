package com.zj.order.controller;

import com.zj.order.entity.ResponseJson;

public interface IOrderDetailsController {
	public ResponseJson findByOid(Long oid);

}
