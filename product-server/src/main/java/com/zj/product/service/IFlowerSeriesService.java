package com.zj.product.service;

import com.zj.product.entity.FlowerSeries;
import com.zj.product.entity.ResponseJson;

public interface IFlowerSeriesService {
	public ResponseJson findAll();

	public ResponseJson update(FlowerSeries flowerSeries);

	public ResponseJson insert(String sname);

}
