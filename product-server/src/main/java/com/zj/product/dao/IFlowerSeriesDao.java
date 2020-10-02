package com.zj.product.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zj.product.entity.FlowerSeries;

@Repository
public interface IFlowerSeriesDao {
	public List<FlowerSeries> findAll();

	public Integer insert(FlowerSeries flowerSeries);

	public Integer update(FlowerSeries flowerSeries);

}
