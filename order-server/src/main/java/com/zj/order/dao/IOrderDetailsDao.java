package com.zj.order.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zj.order.entity.OrderDetails;

@Repository
public interface IOrderDetailsDao {
	public List<OrderDetails> findByOid(Long oid);

	public Integer insert(List<OrderDetails> lisOrderDetails);
}
