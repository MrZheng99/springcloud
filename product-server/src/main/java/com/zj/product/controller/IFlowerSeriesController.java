package com.zj.product.controller;

import com.zj.product.entity.FlowerSeries;
import com.zj.product.entity.ResponseJson;

public interface IFlowerSeriesController {
	public ResponseJson findAll();

	public ResponseJson update(FlowerSeries flowerSeries);

	public ResponseJson insert(String sname);

}
