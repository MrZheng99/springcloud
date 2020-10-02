package com.zj.order.service;

import com.zj.order.entity.ResponseJson;

public interface IOrderDetailsService {
	public ResponseJson findByOid(Long oid);

}
